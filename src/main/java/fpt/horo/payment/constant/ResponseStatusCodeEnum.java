package fpt.horo.payment.constant;

public interface ResponseStatusCodeEnum {
    ResponseStatusCode SUCCESS = ResponseStatusCode.builder().code("00").httpCode(200).build();
    ResponseStatusCode BUSINESS_ERROR = ResponseStatusCode.builder().code("BSA0001").httpCode(400).build();
    ResponseStatusCode VALIDATION_ERROR = ResponseStatusCode.builder().code("BSA0002").httpCode(400).build();
    ResponseStatusCode INTERNAL_GENERAL_SERVER_ERROR = ResponseStatusCode.builder().code("BSA0003").httpCode(500).build();
    ResponseStatusCode ERROR_BODY_CLIENT = ResponseStatusCode.builder().code("BSA0004").httpCode(400).build();
    ResponseStatusCode ERROR_BODY_REQUIRED = ResponseStatusCode.builder().code("BSA0005").httpCode(400).build();

    public class ResponsePayment{
        ResponseStatusCode SUCCESS = ResponseStatusCode.builder().code("00").httpCode(200).build();
        ResponseStatusCode FAIL = ResponseStatusCode.builder().code("01").httpCode(200).build();
        ResponseStatusCode WRONG_CHECK_SUM = ResponseStatusCode.builder().code("02").httpCode(200).build();
        ResponseStatusCode BUSSINESS_ERROR = ResponseStatusCode.builder().code("03").httpCode(200).build();
    }
}