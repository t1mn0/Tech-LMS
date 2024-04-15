package com.foqs.dto;


import java.time.OffsetDateTime;

public class ApiError {
    private String message;
    private final OffsetDateTime dateOccurred;

    public ApiError(String message) {
        this.message = message;
        this.dateOccurred = OffsetDateTime.now();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public OffsetDateTime getDateOccurred(){
        return dateOccurred;
    }
}
