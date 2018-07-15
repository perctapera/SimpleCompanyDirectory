package com.percival.test.repository;

import com.percival.test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User getOne(Long userId);

    @Override
    List<User> findAll();

    User findByEmailOrUsername(String email, String username);

    @Override
    void delete(User user);

    User deleteUserById(Long id);
    User findByToken(String token);

}
