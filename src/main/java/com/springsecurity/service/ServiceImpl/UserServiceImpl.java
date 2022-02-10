package com.springsecurity.service.ServiceImpl;

import com.springsecurity.exception.NotFoundException;
import com.springsecurity.model.UserAccount;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccount findByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(() -> new NotFoundException("User Name not found"));
    }

    @Override
    public UserAccount fetchUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public UserAccount registration(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
