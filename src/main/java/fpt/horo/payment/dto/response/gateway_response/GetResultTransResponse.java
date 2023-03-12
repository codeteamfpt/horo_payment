package fpt.horo.payment.dto.response.gateway_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetResultTransResponse {
    @JsonProperty("error_code")
    String errorCode;
    @JsonProperty("merchant_code")
    String merchantCode;
    @JsonProperty("order_id")
    String orderId;
    @JsonProperty("return_url")
    String returnUrl;
    @JsonProperty("return_bill_code")
    String returnBillCode;
    @JsonProperty("return_other_in")
    String returnOtherIn;
    @JsonProperty("check_sum")
    String checkSum;
}
