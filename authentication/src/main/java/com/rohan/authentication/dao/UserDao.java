package com.rohan.authentication.dao;

import com.rohan.authentication.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String email);
}
