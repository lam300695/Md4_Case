package com.codegym.service;

import com.codegym.model.Type;
import com.codegym.model.User;

public interface UserService {

   Iterable<User> findAll();

   public void save(User user);
   public User findByUserName(String userName);
}
