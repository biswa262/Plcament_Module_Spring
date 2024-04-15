package com.example.placementmodule.Exception;

public class DataNotFound extends RuntimeException{
    public DataNotFound() {
    }

    public DataNotFound(String message) {
        super(message);
    }
}
