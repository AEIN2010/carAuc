package com.example.caraucbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, String> {

    public User findUserByUsernameIsAndPasswordIs(String username, String password);


}
