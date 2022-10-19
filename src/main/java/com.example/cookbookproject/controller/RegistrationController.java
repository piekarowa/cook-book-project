package com.example.cookbookproject.controller;

import com.example.cookbookproject.exception.EmptyUsernameException;
import com.example.cookbookproject.model.User;
import com.example.cookbookproject.service.AutoLoginService;
import com.example.cookbookproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    private final AutoLoginService autoLoginService;

    public RegistrationController(UserService userService, AutoLoginService autoLoginService) {
        this.userService = userService;
        this.autoLoginService = autoLoginService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(ModelMap modelMap){
        modelMap.addAttribute("emptyUser", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String handleNewUser(@ModelAttribute("emptyUser") User user, ModelMap modelMap){

        log.info("Received new user: " + user.getUsername());

        try {
            if(userService.existsByUsername(user.getUsername())){
                log.info("User with username " + user.getUsername() + " exists!");
                modelMap.addAttribute("exceptionMessage", "User with username " + user.getUsername() + " exists!");
                return "registration";
            }
        } catch (EmptyUsernameException e) {
            log.info(e.getMessage());
            modelMap.addAttribute("exceptionMessage", e.getMessage());
            return "registration";
        }

        userService.save(user);

        autoLoginService.autologin(user.getUsername());

        return "redirect:/search";
    }

}
