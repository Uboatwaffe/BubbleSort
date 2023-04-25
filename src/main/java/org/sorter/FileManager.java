package org.sorter;

import org.sorter.Exceptions.DeletingFile;
import org.sorter.Exceptions.CustomException;

import java.io.File;
import java.io.IOException;

public class FileManager {
    // Stores default path to file
    private static String fileName = "src/main/resources/numbers.txt";

    // Sets new file path
    protected static void setFileName(String file_name){
        fileName = "src/main/resources/" + file_name;
    }

    // Returns file path
    protected static String getFileName(){
        return fileName;
    }

    // Creates file
    protected static void createFile(String FileName) {

        // Checks if extension is correct
        CheckingExtension checkingExtension = new CheckingExtension();
        if (checkingExtension.check(fileName)) {

            // Try to create file
            try {
                File f = new File(FileName);

                if (!f.createNewFile())
                    throw new CustomException("File not created");

            } catch (IOException e) {
                System.out.println("Something went wrong...");
            } catch (CustomException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    // Deletes file
    protected static void deleteFile(String fileName){

        // Try to delete file
        try {
            File file = new File("src/main/resources/" + fileName);

            if(!file.delete())
                throw new DeletingFile("File could not be deleted!");

        }catch(SecurityException e){
            System.out.println("File couldn't be deleted");
        }catch(DeletingFile e){
            System.out.println(e.getMessage());
        }
    }
}
