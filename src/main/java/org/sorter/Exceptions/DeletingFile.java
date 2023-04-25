package org.sorter.Exceptions;

public class DeletingFile extends Exception {

    // This is simple custom-made exception only to be thrown when file is created
    String message;

    public DeletingFile(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}