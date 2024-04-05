package com.example.caraucbackend;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    /*
    List of all end-points:
    --to get all cars: http://127.0.0.1:8080/cars/all
    --to get car by Id: http://127.0.0.1:8080/cars/{id}
    --to get cars by make: http://127.0.0.1:8080/cars?make=...
    --to login: http://127.0.0.1:8080/login
    add Json body to the request
    {
    "username": "Mark",
    "password": "1234"
    }

     */



    @Autowired
    private CarServices carServices;
    @Autowired
    private UserServices userServices;


    @GetMapping("/cars/all")
    @ResponseBody
    private List<Car> getAll(){
        return carServices.getAllCars();
    }


    @GetMapping("/cars")
    @ResponseBody
    private List<Car> getCarsByMake(@PathParam("make") String make){
        return carServices.getCarsByMake(make);
    }


    @GetMapping("/cars/{id}")
    @ResponseBody
    private Car getCarById(@PathVariable String id){
        return carServices.getCarById(id);
    }


    @GetMapping("/login")
    @ResponseBody
    private User userLoginToPage(@RequestBody User user){
        return userServices.login(user);
    }

}
