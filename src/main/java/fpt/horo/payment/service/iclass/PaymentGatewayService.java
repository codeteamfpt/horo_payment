package fpt.horo.payment.service.iclass;

import fpt.horo.payment.dto.request.gateway_request.ConfirmTransRequest;
import fpt.horo.payment.dto.request.gateway_request.GetResultTransRequest;
import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import fpt.horo.payment.dto.response.gateway_response.GetResultTransResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentGatewayService {

    ConfirmTransResponse confirmTrans(ConfirmTransRequest request);

    GetResultTransResponse getResultTrans(GetResultTransRequest request);
}
