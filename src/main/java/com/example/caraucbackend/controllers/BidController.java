package com.example.caraucbackend.controllers;


import com.example.caraucbackend.DTOs.GeneralResponse;
import com.example.caraucbackend.DTOs.Requests.NewBidRequest;
import com.example.caraucbackend.services.BidServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bids")
public class BidController {


    @Autowired
    private BidServices bidServices;

    @PostMapping("/new")
    @ResponseBody
    private GeneralResponse addNewBid(@RequestBody NewBidRequest bidRequest){
        return bidServices.addNewBid(bidRequest);
    }
}
