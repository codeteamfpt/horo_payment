package fpt.horo.payment.repository;

import fpt.horo.payment.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Override
    List<User> findAll();
}
