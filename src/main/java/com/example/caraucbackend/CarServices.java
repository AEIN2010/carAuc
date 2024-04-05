package com.example.caraucbackend;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServices {

    private final CarRepo carRepo;

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }

    public Car getCarById(String id){
        return carRepo.findCarByIdIs(id);
    }

    public List<Car> getCarsByMake(String make){
        return carRepo.findCarsByMakeIs(make);
    }

}
