package br.com.helpdesk.api.repository;

import br.com.helpdesk.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Users extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}
