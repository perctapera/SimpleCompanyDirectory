package com.percival.test.services;

import com.percival.test.models.User;

import java.util.List;

public interface UserService {

    User getOne(Long userId);

    List<User> findAll();

    User findByEmailOrUsername(String email, String username);

    void delete(User user);

    User deleteUserById(Long id);

    User saveUser(User user);
    User findByToken(String token);

}
