package org.sorter.Exceptions;

public class CustomException extends Exception{
    private final String message;
    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
