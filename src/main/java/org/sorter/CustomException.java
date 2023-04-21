package org.sorter;

public class CustomException extends Exception{
    private final String message;
    CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
