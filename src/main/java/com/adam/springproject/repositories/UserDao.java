package com.adam.springproject.repositories;

import com.adam.springproject.repositories.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findUserByAccount(String account);
}
