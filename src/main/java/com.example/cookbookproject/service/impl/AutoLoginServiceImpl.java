package com.example.cookbookproject.service.impl;

import com.example.cookbookproject.service.AutoLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AutoLoginServiceImpl implements AutoLoginService {

    private final UserDetailsService userDetailsService;

    public AutoLoginServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void autologin(String username) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        if(token.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(token);
            log.info("Successfully autologin user with username: " + username);
        }

    }
}
