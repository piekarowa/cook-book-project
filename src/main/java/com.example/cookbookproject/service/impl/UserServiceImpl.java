package com.example.cookbookproject.service.impl;

import com.example.cookbookproject.exception.EmptyUsernameException;
import com.example.cookbookproject.model.Role;
import com.example.cookbookproject.model.User;
import com.example.cookbookproject.repository.RoleRepository;
import com.example.cookbookproject.repository.UserRepository;
import com.example.cookbookproject.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean existsByUsername(String username) throws EmptyUsernameException {
        if(username == null || username.isBlank()){
            throw new EmptyUsernameException("Username cannot be empty!");
        }

        return userRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setRoles(getUserRoles());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEmail(user.getEmail());
        userRepository.save(user);

    }

    private List<Role> getUserRoles(){
        Role userRole = roleRepository.findByName("USER");
        return Arrays.asList(userRole);
    }
}
