package fpt.horo.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateTransResponse {
    private String transMsisdn;
    private String transAccountId;
    private Long status;
    private String errorCode;
    private String errorMessage;
    private Double transAmount;
    private Date createDate;
    private Date updateDate;
    private String transType;
    private String orderId;
}
