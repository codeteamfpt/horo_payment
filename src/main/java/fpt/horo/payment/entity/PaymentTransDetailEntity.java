package fpt.horo.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment_trans_detail")
public class PaymentTransDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_trans_detail_id")
    private Long PaymentTransDetailId;
    @Column(name = "trans_msisdn")
    private String transMsisdn;
    @Column(name = "trans_account_id")
    private String transAccountId;
    @Column(name = "status")
    private Long status;
    @Column(name = "error_code")
    private String errorCode;
    @Column(name = "error_message")
    private String errorMessage;
    @Column(name = "trans_amount")
    private Double transAmount;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "check_sum")
    private String checkSum;
    @Column(name = "trans_type")
    private String transType;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "vt_transaction_id")
    private String vtTransactionId;
}
