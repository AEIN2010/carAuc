package com.example.caraucbackend.controllers;

import com.example.caraucbackend.entities.Car;
import com.example.caraucbackend.services.CarServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class CarsController {



    @Autowired
    private CarServices carServices;


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



}
