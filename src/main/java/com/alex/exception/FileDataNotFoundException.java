package com.alex.exception;

/**
 * Created by malex on 09.06.16.
 */
public class FileDataNotFoundException extends AppException {
    public FileDataNotFoundException() {
    }

    public FileDataNotFoundException(String message) {
        super(message);
    }

    public FileDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
