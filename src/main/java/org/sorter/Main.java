package org.sorter;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO make interface
        //TODO when creating file make user inserting numbers
        //TODO be able to see all files
        //TODO be able to delete files

        // Variables
        String filename = file.getFileName();
        String container;
        String ignore;
        boolean exit = false;
        boolean set = false;
        int choice;
        int checker;

        // Objects
        Writing writer = null;
        Reading rd = null;
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
        Scanner sc = new Scanner(System.in);

        // Asks user does he want to use preset file
        System.out.print("Do you want to use file: " + filename + " ? ([1] yes; [2] no) ");
        choice = sc.nextInt();

        // Clearing
        sc.nextLine();

        // If so asks the user about the name of that file
        if (choice == 2){
            System.out.print("What new file name is? ");
            file.setFileName(sc.nextLine());
        }

        // Sets writer and reader
        writer = new Writing(file.getFileName());
        rd = new Reading(file.getFileName());
        // Checks if file exists
        checker = rd.howMany();
        if (checker < 0)
            set = true;

        do {
            try {

                if (!set) {
                    // File or manually
                    System.out.print("Do you want to insert numbers from file (1), via terminal (2), change file (3) or close program (4)? ");
                    choice = sc.nextInt();
                }

                if (choice == 4) {
                    exit = true;
                    continue;
                } else if (choice == 3 && !set) {
                    // Clears
                    sc.nextLine();

                    // If so asks the user about the name of that file
                    System.out.print("What new file name is? ");
                    file.setFileName(sc.nextLine());

                    // Sets writer and reader
                    writer = new Writing(file.getFileName());
                    rd = new Reading(file.getFileName());
                } else if (choice == 2) {

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

                    writer.write(db);
                }

                // All operations
                checker = rd.howMany();
                if (checker > 0) {
                    writer.write(
                            pa.parse(
                                    sorter.sort(
                                            rd.read(
                                                    checker
                                            )
                                    )
                            )
                    );


                    // Tells user everything went fine
                    System.out.println("All numbers sorted\nYou can see them in file " + file.getFileName() + " or see them now by clicking 1:");
                    choice = sc.nextInt();

                    // Optionally shows numbers
                    if (choice == 1) {

                        // Creates array
                        int[] db2;

                        // Assigns array
                        db2 = rd.read(rd.howMany());

                        // Prints out array
                        for (int x :
                                db2) {
                            System.out.println(x);
                        }
                    }
                } else {
                    System.out.println("File is empty use terminal first!");
                }
            }catch(InputMismatchException e){
                System.out.println("Wrong character inserted");
            }
        }while (!exit);
    }
}