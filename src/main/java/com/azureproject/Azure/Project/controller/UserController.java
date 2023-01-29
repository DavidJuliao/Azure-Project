package com.azureproject.Azure.Project.controller;

import com.azureproject.Azure.Project.model.UserData;
import com.azureproject.Azure.Project.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserData> listAllUsers(){
        return userDetailsService.getUsers();
    }
}
