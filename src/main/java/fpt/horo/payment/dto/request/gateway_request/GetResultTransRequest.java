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
public class GetResultTransRequest {

    @JsonProperty("billcode")
    String billcode;
    @JsonProperty("cust_msisdn")
    String custMsisdn;
    @JsonProperty("error_code")
    String error_code;
    @JsonProperty("merchant_code")
    String merchantCode;
    @JsonProperty("order_id")
    Integer orderId;
    @JsonProperty("payment_status")
    Long paymentStatus;
    @JsonProperty("trans_amount")
    Double transAmount;
    @JsonProperty("vt_transaction_id")
    String vtTransactionId;
    @JsonProperty("check_sum")
    String checkSum;
}
