package fpt.horo.payment.service.impl;

import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.request.gateway_request.GetResultTransRequest;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import fpt.horo.payment.dto.response.gateway_response.GetResultTransResponse;
import fpt.horo.payment.service.iclass.PaymentGatewayService;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

    @Override
    public ConfirmTransResponse confirmTrans(ConfirmTransRequest request) {
        return null;
    }

    @Override
    public GetResultTransResponse getResultTrans(GetResultTransRequest request) {
        return null;
    }
}
