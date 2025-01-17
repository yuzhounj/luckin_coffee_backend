package org.example.manage.repository;

import org.example.manage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // 根据用户名查找用户
    User findByUsername(String username);

    User findByPhone(String phone);

    List<User> findAllByRole(User.Role role);
}