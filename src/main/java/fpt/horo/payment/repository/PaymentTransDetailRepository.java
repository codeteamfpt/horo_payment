package fpt.horo.payment.repository;

import fpt.horo.payment.entity.PaymentTransDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransDetailRepository extends JpaRepository<PaymentTransDetailEntity, Long> {
    PaymentTransDetailEntity findByOrderId(String orderId);

    PaymentTransDetailEntity findByOrderIdAndStatus(String orderId, Long status);

}
