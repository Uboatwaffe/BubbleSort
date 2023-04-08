package org.sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading {
    protected int howMany(){
        var counter = 0;
        int ignore;
        try (Scanner sc = new Scanner(new File("src/main/resources/numbers.txt"))) {
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
        int[] db = new int[a];
        try (Scanner sc = new Scanner(new File("src/main/resources/numbers.txt"))) {
            for (int i = 0; i < a; i++) {
                db[i] = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return db;
    }
}
