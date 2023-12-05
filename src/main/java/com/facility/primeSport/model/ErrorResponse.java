package com.facility.primeSport.model;

import lombok.*;


public record ErrorResponse(

        String error,
        String message
){}
