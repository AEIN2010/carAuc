package com.example.caraucbackend;


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
