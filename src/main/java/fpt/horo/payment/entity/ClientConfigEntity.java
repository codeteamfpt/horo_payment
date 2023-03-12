package fpt.horo.payment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "client_config")
public class ClientConfigEntity {
    @Id
    @Column(name = "client_config_id")
    private Long clientConfigId;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String clientSecret;
}
