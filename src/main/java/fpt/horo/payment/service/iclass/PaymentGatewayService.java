package fpt.horo.payment.service.iclass;

import fpt.horo.payment.dto.response.gateway_response.ConfirmTransResponse;
import fpt.horo.payment.dto.response.gateway_response.GetResultTransResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public interface PaymentGatewayService {

    ConfirmTransResponse confirmTrans(MultiValueMap<String, String> request);

    GetResultTransResponse getResultTrans(MultiValueMap<String, String> request);
}
