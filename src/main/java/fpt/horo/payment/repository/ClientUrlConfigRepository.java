package fpt.horo.payment.repository;


import fpt.horo.payment.entity.ClientUrlConfigEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUrlConfigRepository extends JpaRepository<ClientUrlConfigEntity, Long> {

    @Cacheable("findFirstByClientIdAndClientUrl")
    ClientUrlConfigEntity findFirstByClientIdAndClientUrl(String clientId, String clientUrl);
}
