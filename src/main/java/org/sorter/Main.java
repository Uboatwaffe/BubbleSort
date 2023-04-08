package org.sorter;

import java.io.File;
import java.io.FileNotFoundException;
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

        }
    }
}