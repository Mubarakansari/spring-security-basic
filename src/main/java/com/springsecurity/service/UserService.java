package com.springsecurity.service;

import com.springsecurity.model.UserAccount;

public interface UserService {
    UserAccount findByUserName(String userName);

    UserAccount fetchUser(Long userId);

    UserAccount registration(UserAccount user);
}
