package com.example.caraucbackend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private String name;

    @Id
    private String username;
    private String password;
    private char isAdmin;
}
