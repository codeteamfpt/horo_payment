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
public class ConfirmTransResponse {
    @JsonProperty("billcode")
    String billCode;
    @JsonProperty("merchant_code")
    String merchantCode;
    @JsonProperty("order_id")
    String orderId;
    @JsonProperty("trans_amount")
    String transAmount;
    @JsonProperty("error_code")
    String errorCode;
    @JsonProperty("check_sum")
    String checkSum;
}
