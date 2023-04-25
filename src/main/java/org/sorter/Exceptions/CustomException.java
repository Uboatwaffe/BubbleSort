package org.sorter.Exceptions;

public class CustomException extends Exception{

    // This is simple custom-made exception to be used in general use

    private final String message;
    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
