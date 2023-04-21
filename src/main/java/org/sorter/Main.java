package org.sorter;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //-----!!!THIS IS FINAL VERSION!!!-----\\

        // Variables
        String container;
        String ignore;
        String filename = "numbers.txt";
        int choice;
        int checker;

        // Objects
        Writing writer = new Writing("src/main/resources/" + filename);
        Reading rd = new Reading("src/main/resources/" + filename);
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
        Scanner sc = new Scanner(System.in);


        // File or manually
        System.out.print("Do you want to insert numbers from file (1) or via terminal (2) ? ");
        choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Do you want to use file: " + filename + " ? ([1] yes; [2] no)");
            choice = sc.nextInt();
            if (choice == 1){
                System.out.print("What new file name is? ");
                filename = sc.nextLine();
            }
        }else {

            // Taking information about how many numbers will be inserted
            System.out.println("How many numbers you want to insert?");
            choice = sc.nextInt();

            // Clearing
            sc.nextLine();

            // Creating array for all numbers
            String[] db = new String[choice];

            // Inserting numbers
            for (int i = 0; i < choice; i++) {
                System.out.print("Insert number no. " + (i + 1) + ": ");
                container = sc.nextLine();
                try {
                    checker = Integer.parseInt(container);
                    db[i] = container;
                } catch (NumberFormatException e) {
                    System.out.println("You cannot insert word!");
                    i--;
                }
            }

            // Inserting numbers into file
            writer.write(db);
        }

        // All operations
        writer.write(pa.parse(sorter.sort(rd.read(rd.howMany()))));

        // Tells user everything went fine
        System.out.println("All numbers sorted\nYou can see them in file numbers.txt or see them now by clicking 1:");
        choice = sc.nextInt();

        // Optionally shows numbers
        if (choice == 1) {

            // Creates array
            int[] db;

            // Assigns array
            db = rd.read(rd.howMany());

            // Prints out array
            for (int x :
                    db) {
                System.out.println(x);
            }
        }

    }
}