package com.alex.exception;

/**
 * Created by malex on 12.06.16.
 */
public class ListCityIsEmptyException extends AppException {
    public ListCityIsEmptyException() {
    }

    public ListCityIsEmptyException(String message) {
        super(message);
    }

    public ListCityIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
