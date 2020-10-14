package br.com.helpdesk.api.service.impl;

import br.com.helpdesk.api.entity.User;
import br.com.helpdesk.api.repository.Users;
import br.com.helpdesk.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Users users;

    @Override
    public Optional<User> findByEmail(String email) {
        return users.findByEmail(email);
    }

    @Override
    public User createOrUpdate(User user) {
        return users.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return users.findById(id);
    }

    @Override
    public void delete(String id) {
        users.deleteById(id);
    }

    @Override
    public Page<User> findAll(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return users.findAll(pageable);
    }

}
