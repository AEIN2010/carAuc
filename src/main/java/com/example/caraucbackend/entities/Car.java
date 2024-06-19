package com.example.caraucbackend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {

    @Id
    private String vin;
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    private String year;
    @NotNull
    private long price;
    @NotNull
    private String image;
    @NotNull
    private String mileage;
    @NotNull
    @ColumnDefault("1")
    private CarStatus carStatus;


    @ManyToOne
    @NotNull
    private User lister;

    @OneToMany
    private List<Bid> bidHistory;

    public Car(String vin, String make, String model, String year, long price, String image, String mileage, User lister, List<Bid> bidHistory) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.image = image;
        this.mileage = mileage;
        this.lister = lister;
        this.bidHistory = bidHistory;
    }
}
