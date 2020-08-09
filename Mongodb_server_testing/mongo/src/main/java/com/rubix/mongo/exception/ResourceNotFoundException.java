package com.rubix.mongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* Returns the message of user details when there is a response */



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class  ResourceNotFoundException  extends Exception{

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}