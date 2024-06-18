package edu.patterns.shapes.exception;

import java.io.IOException;

public class InvalidCoordinateException extends IOException {
    public InvalidCoordinateException(String message) {
        super(message);
    }
}