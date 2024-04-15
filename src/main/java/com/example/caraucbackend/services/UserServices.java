package com.example.caraucbackend.services;


import com.example.caraucbackend.repos.UserRepo;
import com.example.caraucbackend.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepo userRepo;

    public User login(User user){
        return userRepo.findUserByUsernameIsAndPasswordIs(user.getUsername(), user.getPassword());
    }
}
