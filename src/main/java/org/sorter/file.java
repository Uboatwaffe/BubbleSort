package org.sorter;

import java.io.File;
import java.io.IOException;

public class file {
    private static String fileName = "src/main/resources/numbers.txt";
    private static int j;
    protected static void setFileName(String file_name){
        fileName = "src/main/resources/" + file_name;
    }
    protected static String getFileName(){
        return fileName;
    }
    protected static int createFile(String FileName) {
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
            j = -1;
        } catch (CreatingFile error){
            j = -1;
        }
        return j;
    }
}
