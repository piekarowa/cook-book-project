package com.example.cookbookproject.service;

import com.example.cookbookproject.exception.EmptyUsernameException;
import com.example.cookbookproject.model.User;

public interface UserService {

    boolean existsByUsername(String username) throws EmptyUsernameException;

    void save(User user);

}
