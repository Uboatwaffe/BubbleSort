package org.sorter;

import org.sorter.Exceptions.CreatingFile;
import org.sorter.Exceptions.CustomException;

import java.io.File;
import java.io.IOException;

public class file {
    private static String fileName = "src/main/resources/numbers.txt";

    protected static void setFileName(String file_name){
        fileName = "src/main/resources/" + file_name;
    }
    protected static String getFileName(){
        return fileName;
    }
    protected static void createFile(String FileName) {
        try {
            File f = new File(FileName);
            boolean check = f.createNewFile();
            if (!check) {
                throw new CustomException("File not created");
            }
            throw new CreatingFile();
        }catch (IOException e){
            System.out.println("Something went wrong...");
        }catch (CustomException err) {
            System.out.println(err.getMessage());

        } catch (CreatingFile error){}
    }
    protected static void deleteFile(String fileName){
        try {
            File file = new File("src/main/resources/" + fileName);
            file.delete();
        }catch(SecurityException e){
            System.out.println("File couldn't be deleted");
        }
    }
}
