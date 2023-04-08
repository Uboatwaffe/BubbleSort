package org.sorter;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
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
        if (counter > 0) {
            int[] db = new int[counter];

            try (Scanner sc = new Scanner(new File("src/main/resources/numbers.txt"))) {
                for (int i = 0; i < counter; i++) {
                    db[i] = sc.nextInt();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
            Sorter sorter = new Sorter();
            db = sorter.sort(db);
            String[] sorted = new String[db.length];
            for (int i = 0; i < db.length; i++) {
                sorted[i] = Integer.toString(db[i]);
            }
            try {
                PrintWriter writer = new PrintWriter("src/main/resources/numbers.txt");
                writer.print("");
                writer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            Writing writer = new Writing();
            writer.write(sorted);
        }
    }
}