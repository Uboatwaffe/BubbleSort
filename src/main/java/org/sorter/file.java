package org.sorter;

public class file {
    private static String fileName = "numbers.txt";
    protected static void setFileName(String file_name){
        fileName = file_name;
    }
    protected static String getFileName(){
        return fileName;
    }
}
