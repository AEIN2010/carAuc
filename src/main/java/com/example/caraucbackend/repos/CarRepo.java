package com.example.caraucbackend.repos;

import com.example.caraucbackend.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepo extends JpaRepository<Car, String> {

    Car findCarByIdIs(String carId);

    List<Car> findCarsByMakeIs(String make);

}
