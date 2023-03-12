package fpt.horo.payment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateTransRequest {
    private String transAccountId;
    private Double transAmount;
    private String transType;
    private Date crateDate;
}
