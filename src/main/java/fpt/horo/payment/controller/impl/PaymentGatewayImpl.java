package fpt.horo.payment.controller.impl;

import fpt.horo.payment.constant.ResponseStatusEnum;
import fpt.horo.payment.controller.api.PaymentGatewayApi;
import fpt.horo.payment.dto.GeneralResponse;
import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.request.gateway_request.GetResultTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import fpt.horo.payment.dto.response.gateway_response.GetResultTransResponse;
import fpt.horo.payment.exception.HandleException;
import fpt.horo.payment.service.iclass.PaymentGatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentGatewayImpl implements PaymentGatewayApi {

    @Autowired
    PaymentGatewayService paymentGatewayService;

    @Override
    public ConfirmTransResponse verifyTrans(MultiValueMap<String, String> request) {
        try {
            return paymentGatewayService.confirmTrans(request);
        }catch (Exception e) {
            log.info("PaymentGatewayImpl verifyTrans Exception {}", e.getMessage(), e);
            return ConfirmTransResponse.builder()
                    .errorCode("03")
                    .checkSum("")
                    .billCode("")
                    .merchantCode("")
                    .transAmount("")
                    .orderId("")
                    .build();
        }
    }

    @Override
    public GetResultTransResponse getResultTrans(MultiValueMap<String, String> request) {
        try {
            return paymentGatewayService.getResultTrans(request);
        }catch (Exception e) {
            log.info("PaymentGatewayImpl verifyTrans Exception {}", e.getMessage(), e);
            return GetResultTransResponse.builder()
                    .errorCode("01")
                    .merchantCode("")
                    .orderId("")
                    .returnUrl("")
                    .returnBillCode("")
                    .returnOtherIn("")
                    .checkSum("").build();
        }
    }
}
