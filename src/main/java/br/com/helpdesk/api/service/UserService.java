package br.com.helpdesk.api.service;

import br.com.helpdesk.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByEmail(String email);

    User createOrUpdate(User user);

    Optional<User> findById(String id);

    void delete(String id);

    Page<User> findAll(int page, int count);

}
