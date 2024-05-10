package com.example.caraucbackend.services;


import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.DTOs.Requests.NewCarRequest;
import com.example.caraucbackend.DTOs.ResponseBody;
import com.example.caraucbackend.entities.User;
import com.example.caraucbackend.repos.CarRepo;
import com.example.caraucbackend.entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServices {

    private final CarRepo carRepo;
    private final UserServices userServices;

    public GeneralResponse getAllCars(){
        List<Car> cars = carRepo.findAll();
        for(Car car:cars){
            car.setBidHistory(null);
        }
        return new GeneralResponse(
                HttpStatus.ACCEPTED,
                "car found",
                LocalDate.now(),
                LocalTime.now(),
                new ResponseBody<>(cars)
        );
    }

    public GeneralResponse getCarByVin(String id){
        Car car = carRepo.findCarByVinIs(id);
        return new GeneralResponse(
                HttpStatus.ACCEPTED,
                "car found",
                LocalDate.now(),
                LocalTime.now(),
                new ResponseBody<>(car)
        );
    }

//    public GeneralResponse getCarsByMake(String make){
//        List<Car> cars = carRepo.findCarsByMakeIs(make);
//
//        for(Car car:cars){
//            car.getLister().setCarList(null);
//            car.getLister().setBidsList(null);
//        }
//
//        return new GeneralResponse(
//                HttpStatus.ACCEPTED,
//                "car found",
//                LocalDate.now(),
//                LocalTime.now(),
//                cars
//        );
//    }

    public GeneralResponse addCar(NewCarRequest car){
        User user = userServices.getUserByUserName(car.getListerUsername());
        Car addedCar = carRepo.save(new Car(
                car.getVin(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getPrice(),
                car.getImage(),
                car.getMileage(),
                car.getCarStatus(),
                user,
                new ArrayList<>()
        ));
        addedCar.setLister(user);
        return new GeneralResponse(
                HttpStatus.ACCEPTED,
                "car added successfully",
                LocalDate.now(),
                LocalTime.now(),
                new ResponseBody<>(car)
        );
    }

    public GeneralResponse updateCar(Car car){
        return new GeneralResponse(
                HttpStatus.ACCEPTED,
                "car updated successfully",
                LocalDate.now(),
                LocalTime.now(),
                new ResponseBody<>(carRepo.save(car))
        );
    }


    public GeneralResponse carsListedByUser(String username){

        List<Car> cars = carRepo.findAllByListerUsernameIs(username);

        cars.forEach(car -> {car.setBidHistory(null);
                             car.setLister(null);
                            });

        return new GeneralResponse(
                HttpStatus.FOUND,
                "Cars found for user: "+username,
                LocalDate.now(),
                LocalTime.now(),
                new ResponseBody<>(cars)
        );
    }

}
