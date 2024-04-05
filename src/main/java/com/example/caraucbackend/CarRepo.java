package com.example.caraucbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepo extends JpaRepository<Car, String> {

    public Car findCarByIdIs(String carId);

    public List<Car> findCarsByMakeIs(String make);

}
