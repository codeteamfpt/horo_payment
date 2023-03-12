package fpt.horo.payment.controller.impl;

import fpt.horo.payment.constant.ResponseStatusEnum;
import fpt.horo.payment.controller.api.PaymentDetailApi;
import fpt.horo.payment.dto.GeneralResponse;
import fpt.horo.payment.dto.request.CreateTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import fpt.horo.payment.service.iclass.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentDetailImpl implements PaymentDetailApi {

    @Autowired
    PaymentDetailService paymentDetailService;

    @Override
    public GeneralResponse<CreateTransResponse> createTrans(CreateTransRequest request) {
        try {
            return paymentDetailService.createTrans(request);
        }catch (Exception e) {
            return new GeneralResponse<>(new CreateTransResponse(),ResponseStatusEnum.BUSSINESS_EXCEPTION);
        }
    }
}
