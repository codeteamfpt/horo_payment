package fpt.horo.payment.constant;

import fpt.horo.payment.dto.ResponseStatus;

public interface ResponseStatusEnum {
    ResponseStatus BUSSINESS_EXCEPTION = new ResponseStatus("BSA001","có lỗi xảy ra !","có lỗi xảy ra !");
    ResponseStatus SUCCESS = new ResponseStatus("00","Thành Công !","Thành Công !");

    ResponseStatus REQUEST_NULL_OR_EMPTY = new ResponseStatus("ERR_001","Request không hợp lệ !","Request không hợp lệ !");
    
    ResponseStatus BUSINESS_ERROR = ResponseStatus.builder().code("BSA0001").build();
    ResponseStatus VALIDATION_ERROR = ResponseStatus.builder().code("BSA0002").build();
    ResponseStatus INTERNAL_GENERAL_SERVER_ERROR = ResponseStatus.builder().code("BSA0003").build();
    ResponseStatus ERROR_BODY_CLIENT = ResponseStatus.builder().code("BSA0004").build();
    ResponseStatus ERROR_BODY_REQUIRED = ResponseStatus.builder().code("BSA0005").build();

    public class ResponsePayment {
        public static ResponseStatus SUCCESS = ResponseStatus.builder().code("00").build();
        public static ResponseStatus FAIL_CTT = ResponseStatus.builder().code("01").build();
        public static ResponseStatus WRONG_CHECK_SUM_CTT = ResponseStatus.builder().code("02").build();
        public static ResponseStatus BUSSINESS_ERROR_CTT = ResponseStatus.builder().code("03").build();
        public static ResponseStatus REQUEST_NULL_OR_EMPTY = ResponseStatus.builder().code("ERR_001").build();
        public static ResponseStatus REQUEST_DUPLICATE = ResponseStatus.builder().code("ERR_002").build();
        public static ResponseStatus FAIL_SAVE_DB = ResponseStatus.builder().code("ERR_003").build();
    }
}
