package fpt.horo.payment.controller.impl;

import fpt.horo.payment.controller.api.PaymentGatewayApi;
import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentGatewayImpl implements PaymentGatewayApi {
    @Override
    public ConfirmTransResponse verifyTrans(String authentication, ConfirmTransRequest request) {
        try {
            return ConfirmTransResponse.builder().errorCode("03").build();
        }catch (Exception e) {
            log.info("PaymentGatewayImpl verifyTrans Exception {}", e.getMessage(), e);
            return ConfirmTransResponse.builder().errorCode("03").build();
        }
    }
}
