package com.example.caraucbackend.controllers;

import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.DTOs.GeneralResponseBody;
import com.example.caraucbackend.DTOs.Requests.NewCarRequest;
import com.example.caraucbackend.services.CarServices;
import com.example.caraucbackend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cars")
public class CarsController {



    @Autowired
    private CarServices carServices;
    @Autowired
    private UserServices userServices;


    @GetMapping("/all/{username}/{password}")
    @ResponseBody
    private GeneralResponse getAll(){
        return carServices.getAllCars();
    }


//    @GetMapping("/")
//    @ResponseBody
//    private GeneralResponse getCarsByMake(@PathParam("make") String make){
//        return carServices.getCarsByMake(make);
//    }


    @GetMapping("/vin/{vin}/{username}/{password}")
    @ResponseBody
    private GeneralResponse getCarById(@PathVariable String vin,
                                       @PathVariable String username,
                                       @PathVariable String password){
        if(!userServices.usernameAndPasswordChecker(username, password)){
            return new GeneralResponse(
                    HttpStatus.UNAUTHORIZED,
                    "Wrong Security Credentials",
                    LocalDate.now(),
                    LocalTime.now(),
                    new GeneralResponseBody(null)
            );
        }
        return carServices.getCarByVin(vin);
    }

    @PostMapping("/add/{username}/{password}")
    @ResponseBody
    private GeneralResponse addCar(@RequestBody NewCarRequest car,
                                   @PathVariable String username,
                                   @PathVariable String password){
        if(!userServices.usernameAndPasswordChecker(username, password)){
            return new GeneralResponse(
                    HttpStatus.UNAUTHORIZED,
                    "Wrong Security Credentials",
                    LocalDate.now(),
                    LocalTime.now(),
                    new GeneralResponseBody(null)
            );
        }
        return carServices.addCar(car);
    }

    @GetMapping("/user/{username}/{password}")
    @ResponseBody
    private GeneralResponse getCarsByusername(@PathVariable String username,
                                              @PathVariable String password){
        if(!userServices.usernameAndPasswordChecker(username, password)){
            return new GeneralResponse(
                    HttpStatus.UNAUTHORIZED,
                    "Wrong Security Credentials",
                    LocalDate.now(),
                    LocalTime.now(),
                    new GeneralResponseBody(null)
            );
        }
        return carServices.carsListedByUser(username);
    }



    @GetMapping("/sell/{vin}/{username}/{password}")
    @ResponseBody
    private GeneralResponse markCarAsSold(@PathVariable String vin,
                                       @PathVariable String username,
                                       @PathVariable String password){
        if(!userServices.usernameAndPasswordChecker(username, password)){
            return new GeneralResponse(
                    HttpStatus.UNAUTHORIZED,
                    "Wrong Security Credentials",
                    LocalDate.now(),
                    LocalTime.now(),
                    new GeneralResponseBody(null)
            );
        }
        return carServices.markCarAsSold(vin);
    }

}
