package com.example.caraucbackend.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody<T> {
    private T data;

    public ResponseBody(T data) {
        this.data = data;
    }

    // Getters and setters for data
}
