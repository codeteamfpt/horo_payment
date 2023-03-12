package fpt.horo.payment.service.impl;

import fpt.horo.payment.constant.Constants;
import fpt.horo.payment.constant.ResponseStatusCode;
import fpt.horo.payment.constant.ResponseStatusCodeEnum;
import fpt.horo.payment.constant.ResponseStatusCodeEnum.ResponsePayment;
import fpt.horo.payment.dto.request.CreateTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import fpt.horo.payment.entity.PaymentTransDetailEntity;
import fpt.horo.payment.exception.HandleException;
import fpt.horo.payment.repository.PaymentTransDetailRepository;
import fpt.horo.payment.service.iclass.PaymentDetailService;
import fpt.horo.payment.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentDetailServiceImpl implements PaymentDetailService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private PaymentTransDetailRepository paymentTransDetailRepository;

    @Value("${ctt.vds.access-code}")
    String accessCode;
    @Value("${ctt.vds.merchant-code}")
    String merchantCode;
    @Value("${ctt.vds.hash-key}")
    String hashKey;


    @Override
    public CreateTransResponse createTrans(CreateTransRequest request) throws HandleException {
       CreateTransResponse response = new CreateTransResponse();
        try {
            throwHandleException(checkRequest(request), ResponsePayment.REQUEST_NULL_OR_EMPTY);
            throwHandleException(checkDupRequestId(request.getOrderId()), ResponsePayment.REQUEST_DUPLICATE);
            saveTransDetails(request);
        }catch (HandleException he) {
            log.error("PaymentDetailServiceImpl createTrans ex : {}", he.getMessage(), he);
            throw new HandleException(he.getStatusCode());
        }catch (Exception e) {
            log.error("PaymentDetailServiceImpl createTrans ex : {}", e.getMessage(), e);
            throw new HandleException(ResponseStatusCodeEnum.BUSINESS_ERROR);
        }
        return response;
    }

    private void saveTransDetails(CreateTransRequest request){
        String checkSum = Utils.createCheckSum(accessCode,
                request.getOrderId(),
                merchantCode,
                request.getOrderId(),
                request.getTransAmount(),
                hashKey);
        try {
            PaymentTransDetailEntity entity = PaymentTransDetailEntity.builder()
                    .transAccountId(request.getTransAccountId())
                    .transAmount(request.getTransAmount())
                    .transType(request.getTransType())
                    .createDate(request.getCreatDate())
                    .status(0L)
                    .orderId(request.getOrderId())
                    .checkSum(checkSum)
                    .build();
            paymentTransDetailRepository.save(entity);
        }catch (Exception e){
            log.error("PaymentDetailServiceImpl saveTransDetails ex : {}", e.getMessage(), e);
            throw new HandleException(ResponsePayment.FAIL_SAVE_DB);
        }

    }



    private boolean checkRequest(CreateTransRequest request){
        return request.getTransAccountId() == null
                || request.getTransAmount() == null
                || request.getTransType() == null
                || request.getOrderId() == null;
    }

    private boolean checkDupRequestId(String requestId){
        String key = Constants.REQUEST_CREATE_TRANS.replace("REQUEST_ID", requestId);
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))){
            return true;
        }else{
            redisTemplate.opsForValue().set(key, "1", 30, TimeUnit.DAYS);
            return false;
        }
    }

    private void throwHandleException(boolean isThrow, ResponseStatusCode status) throws HandleException {
        log.info("throwHandleException isThrow : {} reason : {}", isThrow, status);
        if(isThrow) throw new HandleException(status);
    }
}
