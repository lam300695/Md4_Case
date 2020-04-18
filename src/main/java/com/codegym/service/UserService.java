package com.codegym.service;

import com.codegym.model.User;

public interface UserService {
   public User findByUserName(String userName);
}
