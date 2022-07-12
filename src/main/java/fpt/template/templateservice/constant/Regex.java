package fpt.template.templateservice.constant;

import java.util.regex.Pattern;

public class Regex {
    public static final Pattern MSISDN_PATTERN = Pattern.compile("^84\\d+$");
    public static final Pattern ORDER_ID_PATTERN = Pattern.compile("^\\d+$");
    public static final Pattern OTP_PATTERN = Pattern.compile("^\\d{4}$");

    public static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^\\d+$");
    public static final Pattern ONLY_NUMBER_AND_CHAR_PATTERN = Pattern.compile("^[\\d\\w]+$");
    private Regex() {
    }
}
