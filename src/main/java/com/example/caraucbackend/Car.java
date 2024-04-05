package com.example.caraucbackend;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {

    @Id
    private String id;
    private String make;
    private String model;
    private String year;
    private String price;
    private String image;
    private String mileage;
}
