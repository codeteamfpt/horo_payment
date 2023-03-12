package fpt.horo.payment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "client_url_config")
public class ClientUrlConfigEntity {
    @Id
    @Column(name = "client_url_config_id")
    private Long clientUrlConfigId;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_url")
    private String clientUrl;
}
