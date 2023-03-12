package fpt.horo.payment.service.iclass;

import fpt.horo.payment.dto.GeneralResponse;
import fpt.horo.payment.dto.request.CreateTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentDetailService {
    GeneralResponse<CreateTransResponse> createTrans(CreateTransRequest request);
}
