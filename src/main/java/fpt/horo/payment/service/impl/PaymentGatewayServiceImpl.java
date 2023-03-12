package fpt.horo.payment.service.impl;

import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.request.gateway_request.GetResultTransRequest;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import fpt.horo.payment.dto.response.gateway_response.GetResultTransResponse;
import fpt.horo.payment.entity.PaymentTransDetailEntity;
import fpt.horo.payment.exception.HandleException;
import fpt.horo.payment.repository.PaymentTransDetailRepository;
import fpt.horo.payment.service.iclass.PaymentGatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class PaymentGatewayServiceImpl implements PaymentGatewayService {


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


    private ConfirmTransResponse returnFailConfirm(ConfirmTransRequest request, String errorCode) throws HandleException {
        return ConfirmTransResponse.builder()
                .errorCode(errorCode)
                .checkSum(request.getCheckSum())
                .billCode(request.getOrderId())
                .merchantCode(request.getMerchantCode())
                .transAmount("")
                .orderId(request.getOrderId())
                .build();
    }

    @Override
    public ConfirmTransResponse confirmTrans(ConfirmTransRequest request) {
        try {
            if (checkRequestConfirmNull(request)) {
                return returnFailConfirm(request, "01");
            }
            PaymentTransDetailEntity orderEntity = paymentTransDetailRepository.findByOrderId(request.getOrderId());
            if (orderEntity == null) {
                return returnFailConfirm(request, "01");
            }
            if (!orderEntity.getCheckSum().equals(request.getCheckSum())) {
                return returnFailConfirm(request, "02");
            }

            return ConfirmTransResponse.builder()
                    .errorCode("00")
                    .checkSum(orderEntity.getCheckSum())
                    .billCode(orderEntity.getOrderId())
                    .merchantCode(merchantCode)
                    .transAmount(orderEntity.getTransAmount().toString())
                    .orderId(orderEntity.getOrderId())
                    .build();
        } catch (Exception e) {
            return returnFailConfirm(request, "03");
        }
    }

    private boolean checkRequestConfirmNull(ConfirmTransRequest request) {
        return request.getOrderId() == null
                || request.getBillCode() == null
                || request.getMerchantCode() == null
                || request.getCheckSum() == null;
    }

    @Override
    public GetResultTransResponse getResultTrans(GetResultTransRequest request) {
        try {
            if(checkRequestGetResultNull(request)){
                return setResultResponse(request, "01");
            }
            PaymentTransDetailEntity orderEntity = paymentTransDetailRepository.findByOrderId(request.getOrderId());
            if (orderEntity == null){
                return setResultResponse(request, "01");
            }
            orderEntity.setErrorCode(request.getErrorCode());
            orderEntity.setVtTransactionId(request.getVtTransactionId());
            orderEntity.setUpdateDate(new Date());
            orderEntity.setStatus(request.getPaymentStatus());
            orderEntity.setTransMsisdn(request.getCustMsisdn());
            paymentTransDetailRepository.save(orderEntity);
            return setResultResponse(request, "00");
        }catch (Exception e){
            return setResultResponse(request, "01");
        }
    }

    private GetResultTransResponse setResultResponse(GetResultTransRequest request, String errorCode) {
        return GetResultTransResponse.builder()
                .errorCode(errorCode)
                .merchantCode(request.getMerchantCode())
                .orderId(request.getOrderId())
                .returnUrl("")
                .returnBillCode(request.getOrderId())
                .returnOtherIn("")
                .checkSum(request.getCheckSum()).build();
    }

    private boolean checkRequestGetResultNull(GetResultTransRequest request) {
        return request.getBillcode() == null ||
                request.getCustMsisdn() == null ||
                request.getErrorCode() == null ||
                request.getMerchantCode() == null ||
                request.getOrderId() == null ||
                request.getPaymentStatus() == null ||
                request.getTransAmount() == null ||
                request.getVtTransactionId() == null ||
                request.getCheckSum() == null;
    }
}
