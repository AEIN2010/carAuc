package com.example.caraucbackend.repos;

import com.example.caraucbackend.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarRepo extends JpaRepository<Car, String> {

    Car findCarByVinIs(String carId);

    //List<Car> findCarsByMakeIs(String make);

}
