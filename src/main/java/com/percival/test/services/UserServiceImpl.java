package com.percival.test.services;

import com.percival.test.models.User;
import com.percival.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User getOne(Long userId) {
        return repository.getOne(userId);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByEmailOrUsername(String email, String username) {
        return repository.findByEmailOrUsername(email,username);
    }

    @Override
    public void delete(User user) {
repository.delete(user);
    }

    @Override
    public User deleteUserById(Long id) {
        return repository.deleteUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findByToken(String token) {
        return repository.findByToken(token);
    }
}
