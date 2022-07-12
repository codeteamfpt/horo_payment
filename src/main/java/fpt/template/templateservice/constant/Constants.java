package fpt.template.templateservice.constant;

import org.springframework.http.HttpStatus;

public final class Constants {
    // Định dạng Số điện thoại/thuê bao
    public static final String MSISDN_FORMAT = "(84[0-9]{9})";

    // Định dạng mã giao dịch
    public static final String REQUEST_ID_FORMAT = "([0-9]{15})";

    // Định dạng mã phiên chat
    public static final String CHATBOT_TRANS_ID_FORMAT = "([a-zA-z0-9]{15})";

    // Định dạng mã ngân hàng
    public static final String BANK_CODE_FORMAT = "([a-zA-z0-9]{0,10})";

    // Định dạng ngày
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    // Định dạng ngày ngắn gọn
    public static final String SHORT_DATE_FORMAT = "yyMMdd";

    public static final String MAX_TIME_VALUE = "999999999";
    public static final String MIN_TIME_VALUE = "000000000";

    // Định dạng ngày giờ
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static final ResponseStatusCode REQUEST_SUCCESS = ResponseStatusCode.builder().code("00").httpCode(200).build();
    public static final ResponseStatusCode BUSINESS_ERROR = ResponseStatusCode.builder().code("BSA0001").httpCode(400).build();
    public static final ResponseStatusCode VALIDATION_ERROR = ResponseStatusCode.builder().code("BSA0002").httpCode(400).build();
    public static final ResponseStatusCode INTERNAL_GENERAL_SERVER_ERROR = ResponseStatusCode.builder().code("BSA0003").httpCode(500).build();
    public static final ResponseStatusCode ERROR_BODY_CLIENT = ResponseStatusCode.builder().code("BSA0004").httpCode(400).build();
    public static final ResponseStatusCode ERROR_BODY_REQUIRED = ResponseStatusCode.builder().code("BSA0005").httpCode(400).build();
    public static final ResponseStatusCode DATA_NOT_FOUND = ResponseStatusCode.builder().code("01").httpCode(200).build();
    public static final ResponseStatusCode TOKEN_ERROR = ResponseStatusCode.builder().code("CB_22").httpCode(200).build();
    public static final ResponseStatusCode FORBIDDEN_INVALID_KEY = ResponseStatusCode.builder().code(Constants.MSG.INTERNAL_ERROR).httpCode(HttpStatus.FORBIDDEN.value()).build();
    public static final ResponseStatusCode FORBIDDEN_TOKEN_EXPIRE = ResponseStatusCode.builder().code(Constants.MSG.TOKEN_EXPIRE).httpCode(HttpStatus.FORBIDDEN.value()).build();
    public static final ResponseStatusCode IS_NULL = ResponseStatusCode.builder().code(Constants.MSG.NULL).httpCode(400).build();
    public static final ResponseStatusCode MAX_LENGTH_EXCEEDED = ResponseStatusCode.builder().code("CB_02").httpCode(400).build();
    public static final ResponseStatusCode PATTERN_INVALID = ResponseStatusCode.builder().code(Constants.MSG.INVALID_FORMAT).httpCode(400).build();
    public static final ResponseStatusCode OTP_TOKEN_INVALID = ResponseStatusCode.builder().code(Constants.MSG.INVALID_FORMAT).httpCode(400).build();

    public final class MSG {

        public static final String NULL = "CB_01";
        public static final String MAX_LENGTH_EXCEEDED = "CB_23";
        public static final String INVALID_FORMAT = "CB_18";
        public static final String INACTIVE_PHONE_NUMBER = "CB_11";
        public static final String OTP_NOT_MATCH = "CB_12";
        public static final String SAVE_OTP_FAIL = "CB_24";
        public static final String SEND_OTP_FAIL = "CB_14";
        public static final String SUCCESS = "CB_00";
        public static final String DATA_NOT_FOUND = "CB_08";
        public static final String NONEXISTENT_BANK_CODE = "CB_15";
        public static final String NUMBER_PHONE_DO_NOT_QUALIFY = "CB_16";
        public static final String INTERNAL_ERROR = "CB_17";
        public static final String PUSHING_NOTI_FAIL = "CB_30";
        public static final String BI_ERROR = "CB_99";
        public static final String UPGRADE_2A_REQUEST_NOT_FOUND = "CB_31";
        public static final String IS_NOT_LINKED_BANK = "CB_33";
        public static final String NOT_FOUND_PAYMENT_SOURCE = "CB_34";
        public static final String TOKEN_EXPIRE = "CB_04";
        public static final String TIMEOUT_CALL_CDCN = "CB_35";

        private MSG() {

        }
    }

    private Constants() {

    }
}
