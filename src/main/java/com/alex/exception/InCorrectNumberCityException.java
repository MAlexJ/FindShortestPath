package com.alex.exception;

/**
 * Created by malex on 07.06.16.
 */
public class InCorrectNumberCityException extends AppException {

    public InCorrectNumberCityException() {
    }

    public InCorrectNumberCityException(String message) {
        super(message);
    }

    public InCorrectNumberCityException(String message, Throwable cause) {
        super(message, cause);
    }
}
