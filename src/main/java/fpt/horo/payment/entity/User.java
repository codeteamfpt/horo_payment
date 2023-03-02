package fpt.horo.payment.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Document(value = "users")
public class User {
    @Id
    private String userId;

    private String username;
}
