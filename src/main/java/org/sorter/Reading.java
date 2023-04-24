package org.sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading {
    private String FileName;
    private boolean created = false;
    private int choice;
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
            System.out.println("File not found\nDo you want to create one? ([1] yes; [2] no) ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice == 1) {
                  FileManager.createFile(FileName);
                  counter = -2;
            }else
                counter = -1;
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
    protected String[] readString(int a){

        // Reading all records from file
        String[] db = new String[a];
        try (Scanner sc = new Scanner(new File(FileName))) {
            for (int i = 0; i < a; i++) {
                db[i] = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return db;
    }
}
