package org.sorter;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //----!!!THIS IS FINAL VERSION!!!----\\

        // Objects
        Writing writer = new Writing("src/main/resources/numbers.txt");
        Reading rd = new Reading("src/main/resources/numbers.txt");
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
        Scanner sc = new Scanner(System.in);

        // Variables
        String container;
        String ignore;
        int choice;
        int checker;

        // Taking information about how many numbers will be inserted
        System.out.println("How many numbers you want to insert?");
        choice = sc.nextInt();

        // Clearing
        sc.nextLine();

        // Creating array for all numbers
        String[] db = new String[choice];

        // Inserting numbers
        for (int i = 0; i < choice; i++) {
            System.out.print("Insert number no. " + (i+1) + ": ");
            container = sc.nextLine();
            try{
                checker = Integer.parseInt(container);
                db[i] = container;
            }catch (NumberFormatException e){
                System.out.println("You cannot insert word!");
                i--;
            }
        }

        // Inserting numbers into file
        writer.write(db);

        // All operations
        writer.write(pa.parse(sorter.sort(rd.read(rd.howMany()))));

    }
}