package fpt.template.templateservice.constant;

import java.util.HashMap;
import java.util.Map;

public enum CustomerGenderEnum {
    MALE("MALE", "NAM", "M"),
    FEMALE("FEMALE", "NỮ", "F"),
    UNDEFINED("UNDEFINED", "Không xác định", "U");
    public final String value;
    public final String valueOcr;
    public final String valueVtb;

    CustomerGenderEnum(String value, String valueOcr, String valueVtb) {
        this.value = value;
        this.valueOcr = valueOcr;
        this.valueVtb = valueVtb;
    }

    private static final Map<String, CustomerGenderEnum> mappingValue = new HashMap<>();
    private static final Map<String, CustomerGenderEnum> mappingValueOcr = new HashMap<>();

    static {
        for (CustomerGenderEnum e : CustomerGenderEnum.values()) {
            mappingValue.put(e.value, e);
            mappingValueOcr.put(e.valueOcr.toUpperCase(), e);
        }
    }

    public static CustomerGenderEnum fromValue(String value) {
        return mappingValue.getOrDefault(value, null);
    }

    public static CustomerGenderEnum fromValueOcr(String valueOcr) {
        return mappingValueOcr.getOrDefault(valueOcr.toUpperCase(), UNDEFINED);
    }
}
