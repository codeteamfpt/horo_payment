package fpt.horo.payment.repository;

import fpt.horo.payment.entity.ClientConfigEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientConfigRepository extends JpaRepository<ClientConfigEntity, Long> {

    @Cacheable
    ClientConfigEntity findFirstByClientId(String clientId);

    @Cacheable
    ClientConfigEntity findByClientIdAndClientSecret(String clientId, String clientSecret);
}
