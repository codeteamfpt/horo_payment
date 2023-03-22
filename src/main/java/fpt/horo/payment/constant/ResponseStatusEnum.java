package fpt.horo.payment.constant;

import fpt.horo.payment.dto.ResponseStatus;

public interface ResponseStatusEnum {
    ResponseStatus BUSSINESS_EXCEPTION = new ResponseStatus("BSA001","có lỗi xảy ra !","có lỗi xảy ra !");
    ResponseStatus SUCCESS = new ResponseStatus("00","Thành Công !","Thành Công !");

    ResponseStatus REQUEST_NULL_OR_EMPTY = new ResponseStatus("ERR_001","Request không hợp lệ !","Request không hợp lệ !");
    
    ResponseStatus BUSINESS_ERROR = ResponseStatus.builder().code("BSA0001").message("BUSINESS_ERROR").build();
    ResponseStatus VALIDATION_ERROR = ResponseStatus.builder().code("BSA0002").message("VALIDATION_ERROR").build();
    ResponseStatus INTERNAL_GENERAL_SERVER_ERROR = ResponseStatus.builder().code("BSA0003").message("INTERNAL_GENERAL_SERVER_ERROR").build();
    ResponseStatus ERROR_BODY_CLIENT = ResponseStatus.builder().code("BSA0004").message("ERROR_BODY_CLIENT").build();
    ResponseStatus ERROR_BODY_REQUIRED = ResponseStatus.builder().code("BSA0005").message("ERROR_BODY_REQUIRED").build();

    public class ResponsePayment {
        public static ResponseStatus SUCCESS = ResponseStatus.builder().code("00").message("SUCCESS").build();
        public static ResponseStatus FAIL_CTT = ResponseStatus.builder().code("01").message("FAIL_CTT").build();
        public static ResponseStatus WRONG_CHECK_SUM_CTT = ResponseStatus.builder().code("02").message("WRONG_CHECK_SUM_CTT").build();
        public static ResponseStatus BUSSINESS_ERROR_CTT = ResponseStatus.builder().code("03").message("BUSSINESS_ERROR_CTT").build();
        public static ResponseStatus REQUEST_NULL_OR_EMPTY = ResponseStatus.builder().code("ERR_001").message("REQUEST_NULL_OR_EMPTY").build();
        public static ResponseStatus REQUEST_DUPLICATE = ResponseStatus.builder().code("ERR_002").message("REQUEST_DUPLICATE").build();
        public static ResponseStatus FAIL_SAVE_DB = ResponseStatus.builder().code("ERR_003").message("FAIL_SAVE_DB").build();
    }
}
