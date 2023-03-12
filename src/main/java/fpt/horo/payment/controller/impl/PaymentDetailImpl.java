package fpt.horo.payment.controller.impl;

import fpt.horo.payment.constant.ResponseStatusEnum;
import fpt.horo.payment.controller.api.PaymentDetailApi;
import fpt.horo.payment.dto.GeneralResponse;
import fpt.horo.payment.dto.request.CreateTransRequest;
import fpt.horo.payment.dto.response.CreateTransResponse;
import fpt.horo.payment.exception.HandleException;
import fpt.horo.payment.service.iclass.PaymentDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentDetailImpl implements PaymentDetailApi {

    @Autowired
    PaymentDetailService paymentDetailService;

    @Override
    public GeneralResponse<CreateTransResponse> createTrans(CreateTransRequest request) {
        try {
            return new GeneralResponse<>(paymentDetailService.createTrans(request),ResponseStatusEnum.SUCCESS);
        }catch (HandleException he) {
            log.error("PaymentDetailImpl createTrans HandleException : {}", he.getMessage(), he);
            return new GeneralResponse<>(new CreateTransResponse(),ResponseStatusEnum.BUSSINESS_EXCEPTION);
        }catch (Exception e) {
            log.error("PaymentDetailImpl createTrans Exception : {}", e.getMessage(), e);
            return new GeneralResponse<>(new CreateTransResponse(),ResponseStatusEnum.BUSSINESS_EXCEPTION);
        }
    }
}
