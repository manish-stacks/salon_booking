package com.codewins.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private String error;
    private String timestamp;

    public ExceptionResponse(String message, String description, LocalDateTime now) {
        this.message = message;
        this.error = description;
        this.timestamp = now.toString();
    }
}
