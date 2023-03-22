package fpt.horo.payment.service.impl;

import fpt.horo.payment.constant.Constants;
import fpt.horo.payment.constant.ResponseStatusEnum;
import fpt.horo.payment.dto.ResponseStatus;
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

@Slf4j
@Service("PaymentDetailService")
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
        try {
            throwHandleException(checkRequest(request), ResponseStatusEnum.ResponsePayment.REQUEST_NULL_OR_EMPTY);
            throwHandleException(checkDupRequestId(request.getOrderId()), ResponseStatusEnum.ResponsePayment.REQUEST_DUPLICATE);
            return saveTransDetails(request);
        }catch (HandleException he) {
            log.error("PaymentDetailServiceImpl createTrans ex : {}", he.getMessage(), he);
            throw new HandleException(he.getStatusCode());
        }catch (Exception e) {
            log.error("PaymentDetailServiceImpl createTrans ex : {}", e.getMessage(), e);
            throw new HandleException(ResponseStatusEnum.BUSSINESS_EXCEPTION);
        }
    }

    private CreateTransResponse saveTransDetails(CreateTransRequest request){
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
            return CreateTransResponse.builder()
                    .createDate(entity.getCreateDate())
                    .transAccountId(entity.getTransAccountId())
                    .orderId(entity.getOrderId())
                    .errorMessage("00")
                    .transMsisdn(entity.getTransMsisdn())
                    .transType(entity.getTransType())
                    .transAmount(entity.getTransAmount())
                    .errorCode("00")
                    .status(entity.getStatus()).build();
        }catch (Exception e){
            log.error("PaymentDetailServiceImpl saveTransDetails ex : {}", e.getMessage(), e);
            throw new HandleException(ResponseStatusEnum.ResponsePayment.FAIL_SAVE_DB);
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

    private void throwHandleException(boolean isThrow, ResponseStatus status) throws HandleException {
        log.info("throwHandleException isThrow : {} reason : {}", isThrow, status);
        if(isThrow) throw new HandleException(status);
    }
}
