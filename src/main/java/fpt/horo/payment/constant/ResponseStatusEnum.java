package fpt.horo.payment.constant;

import fpt.horo.payment.dto.ResponseStatus;

public interface ResponseStatusEnum {
    ResponseStatus BUSSINESS_EXCEPTION = new ResponseStatus("BSA001","có lỗi xảy ra !","có lỗi xảy ra !");
    ResponseStatus SUCCESS = new ResponseStatus("00","Thành Công !","Thành Công !");

    ResponseStatus REQUEST_NULL_OR_EMPTY = new ResponseStatus("ERR_001","Request không hợp lệ !","Request không hợp lệ !");


}
