package fpt.horo.payment.constant;

import fpt.horo.payment.dto.ResponseStatus;

public interface ResponseStatusEnum {
    ResponseStatus BUSSINESS_EXCEPTION = ResponseStatus.builder().code("BSA001").message("có lỗi xảy ra !").displayMessage("có lỗi xảy ra !").build();
}
