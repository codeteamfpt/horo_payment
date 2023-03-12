package fpt.horo.payment.service.impl;

import fpt.horo.payment.dto.GeneralResponse;
import fpt.horo.payment.dto.ResponseStatus;
import fpt.horo.payment.dto.request.CreateTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import fpt.horo.payment.service.iclass.PaymentDetailService;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailServiceImpl implements PaymentDetailService {

    @Override
    public GeneralResponse<CreateTransResponse> createTrans(CreateTransRequest request) {
        return null;
    }

    private GeneralResponse<CreateTransResponse> returlFail(ResponseStatus error) {
        GeneralResponse<CreateTransResponse> response = new GeneralResponse<>();
        response.setStatus(ResponseStatus.builder()
                .code(error.getCode())
                .displayMessage(error.getDisplayMessage())
                .message(error.getMessage())
                .build());
        response.setData(new CreateTransResponse());
        return response;
    }
}
