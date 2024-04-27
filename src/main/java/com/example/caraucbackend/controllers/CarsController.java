package com.example.caraucbackend.controllers;

import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.DTOs.Requests.NewCarRequest;
import com.example.caraucbackend.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/cars")
public class CarsController {



    @Autowired
    private CarServices carServices;


    @GetMapping("/all")
    @ResponseBody
    private GeneralResponse getAll(){
        return carServices.getAllCars();
    }


//    @GetMapping("/")
//    @ResponseBody
//    private GeneralResponse getCarsByMake(@PathParam("make") String make){
//        return carServices.getCarsByMake(make);
//    }


    @GetMapping("/{vin}")
    @ResponseBody
    private GeneralResponse getCarById(@PathVariable String vin){
        return carServices.getCarByVin(vin);
    }

    @PostMapping("/add")
    @ResponseBody
    private GeneralResponse addCar(@RequestBody NewCarRequest car){
        return carServices.addCar(car);
    }



}
