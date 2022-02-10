package com.springsecurity.service.ServiceImpl;

import com.springsecurity.exception.NotFoundException;
import com.springsecurity.model.CustomUserDetails;
import com.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(userRepository.findByUserName(username).orElseThrow(() -> new NotFoundException("UserName or Password Incorrect...")));
    }
}
