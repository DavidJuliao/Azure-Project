package com.azureproject.Azure.Project.service;

import com.azureproject.Azure.Project.model.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = getUser();
        if(isNull(userData)){
            throw  new UsernameNotFoundException(username);
        }

        return new User(userData.getUserName(), userData.getPassword(), new ArrayList<>());

    }

    public UserData getUser(){
        UserData userData  = new UserData();
        userData.setUserName("admin");
        userData.setPassword(bCryptPasswordEncoder.encode("admin"));
        return userData;
    }

    public List<UserData> getUsers(){
        return Collections.singletonList(getUser());
    }
}
