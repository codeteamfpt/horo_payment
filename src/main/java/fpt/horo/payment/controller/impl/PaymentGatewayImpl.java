package fpt.horo.payment.controller.impl;

import fpt.horo.payment.controller.api.PaymentGatewayApi;
import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.request.gateway_request.GetResultTransRequest;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import fpt.horo.payment.dto.response.gateway_response.GetResultTransResponse;
import fpt.horo.payment.service.iclass.PaymentGatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentGatewayImpl implements PaymentGatewayApi {

    @Autowired
    PaymentGatewayService paymentGatewayService;

    @Override
    public ConfirmTransResponse verifyTrans(ConfirmTransRequest request) {
        try {
            return paymentGatewayService.confirmTrans(request);
        }catch (Exception e) {
            log.info("PaymentGatewayImpl verifyTrans Exception {}", e.getMessage(), e);
            return ConfirmTransResponse.builder().errorCode("03").build();
        }
    }

    @Override
    public GetResultTransResponse getResultTrans(GetResultTransRequest request) {
        try {
            return paymentGatewayService.getResultTrans(request);
        }catch (Exception e) {
            log.info("PaymentGatewayImpl verifyTrans Exception {}", e.getMessage(), e);
            return GetResultTransResponse.builder().errorCode("03").build();
        }
    }
}
