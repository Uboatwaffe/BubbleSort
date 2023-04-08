package org.sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading {
    String FileName;
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
