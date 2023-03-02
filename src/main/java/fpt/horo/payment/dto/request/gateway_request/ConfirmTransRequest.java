package fpt.horo.payment.dto.request.gateway_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfirmTransRequest {
    @JsonProperty("billcode")
    String billCode;
    @JsonProperty("merchant_code")
    String merchantCode;
    @JsonProperty("order_id")
    String orderId;
    @JsonProperty("check_sum")
    String checkSum;
}
