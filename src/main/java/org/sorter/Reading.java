package org.sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Reading {
    private String FileName;
    private boolean created = false;
    Reading(String path){
        FileName = path;
    }
    protected int howMany(){

        // Reading how many records file have
        var counter = 0;
        int ignore;
        try (Scanner sc = new Scanner(new File(FileName))) {
            while (sc.hasNextInt()) {
                ignore = sc.nextInt();
                counter++;
            }
        }catch(FileNotFoundException e) {
            System.out.println("File not found");
            try{
                File f = new File("src/main/resources/"+FileName);
                f.createNewFile();
            }catch(IOException er){
                System.out.println("Something went wrong, please inform the developer!");
            }
        }
        return counter;
    }
    protected int[] read(int a){

        // Reading all records from file
        int[] db = new int[a];
        try (Scanner sc = new Scanner(new File(FileName))) {
            for (int i = 0; i < a; i++) {
                db[i] = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return db;
    }
}
