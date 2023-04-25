package org.sorter;


import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Variables
        String fileName = FileManager.getFileName();
        String defaultPath = "src/main/resources/numbers.txt";
        String container = "";
        String ignore;
        boolean exit = false;
        boolean set = false;
        boolean notCreated = true;
        int choice;
        int checker;
        int k = 1;


        // Objects
        Writing FileWriter = new Writing("src/main/resources/ProgramFiles/files.txt");
        Reading FileReader = new Reading("src/main/resources/ProgramFiles/files.txt");
        Writing writer;
        Reading rd;
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
        CheckingExtension checkingExtension = new CheckingExtension();
        Scanner sc = new Scanner(System.in);

        // Arrays
        String[] files = FileReader.readString(999);

        // Asks user does he want to use preset file
        System.out.print("Do you want to use file: " + fileName + " ? ([1] yes; [2] no) ");
        choice = sc.nextInt();

        // Clearing
        sc.nextLine();

        // If so asks the user about the name of that file
        if (choice == 2){
            System.out.print("What new file name is? ");
            container = sc.nextLine();
            if(checkingExtension.check(container))
                FileManager.setFileName(container);
        }

        // Sets writer and reader
        writer = new Writing(FileManager.getFileName());
        rd = new Reading(FileManager.getFileName());

        // Checks if file is not empty/doesn't exist
        checker = rd.howMany();
        if (checker == 0) {

            // If it is empty redirects user to inserting numbers
            set = true;
            choice = 2;
        } else if (checker == -1) {

            // If it doesn't exist returns to default path
            writer = new Writing(defaultPath);
            rd = new Reading(defaultPath);
            System.out.println("Returned to default path: " + defaultPath);
            FileManager.setFileName(defaultPath);
        } else if (checker == -2) {

            // If it exists adds it to files array which stores file names
            files[++k] = container;
        }

        // Main loop
        do {
            try {
                // If statement which allows to jump over displays
                // useful when wanting to redirect user without consent
                if (!set) {

                    // Asks user what action does he want to do
                    System.out.print("""
                            
                            Do you want to insert numbers from file (1),
                            via terminal (2),
                            change file (3),
                            show all files (4),
                            delete file (5),
                            create file (6),
                            show current path (7),
                            or close program (8)?
                            
                            """);
                    choice = sc.nextInt();

                    // Types out "-" for clarity
                    System.out.println("----------------");
                }

                // Switch which does other things when other input is provided
                switch (choice) {
                    case 2 -> {

                        // Taking information about how many numbers will be inserted
                        System.out.println("How many numbers you want to insert?");
                        choice = sc.nextInt();

                        if (choice >= 2) {

                            // Clearing
                            sc.nextLine();

                            // Creating array for all numbers
                            String[] db = new String[choice];

                            // Inserting numbers
                            for (int i = 0; i < choice; i++) {
                                System.out.print("Insert number no. " + (i + 1) + ": ");
                                container = sc.nextLine();
                                try {
                                    Integer.parseInt(container);
                                    db[i] = container;
                                } catch (NumberFormatException e) {
                                    System.out.println("You cannot insert word!");
                                    i--;
                                }
                            }

                            // Writes db array into current file
                            writer.write(db);

                        } else {

                            // If there are less than 2 numbers to sort shows that it cannot be done
                            System.out.println("You need at least 2 numbers to be able to sort them");
                        }

                        // Allows program to work properly
                        set = false;
                        notCreated = true;

                    }
                    case 3 -> {
                        // Clears
                        sc.nextLine();

                        // Asks for new file name
                        System.out.print("What new file name is? ");
                        container = sc.nextLine();

                        // Checks file extension
                        if (checkingExtension.check(container))
                            FileManager.setFileName(container);
                        else
                            System.out.println("Wrong file extension");

                        // Sets writer and reader
                        writer = new Writing(FileManager.getFileName());
                        rd = new Reading(FileManager.getFileName());

                        checker = rd.howMany();

                        // If file is not created returns to default path
                        if (checker == -1) {
                            writer = new Writing(defaultPath);
                            rd = new Reading(defaultPath);
                            System.out.println("Returned to default path: " + defaultPath);
                            notCreated = false;
                        } else if (checker == -2) {

                            // If file is created changes to that's file path
                            System.out.println("Current path: " + FileManager.getFileName());
                            set = true;
                            choice = 2;
                            files[++k] = container;

                            FileWriter.write(files);

                            continue;
                        } else if (checker > 0) {
                            // If file exists changes to that's file path
                            System.out.println("Current path: " + FileManager.getFileName());
                            continue;
                        } else if (checker == 0) {
                            // If file is empty forces user to insert numbers into it
                            set = true;
                            choice = 2;
                        }
                    }
                    case 4 -> {

                        // Prints out all files that exists int resources directory
                        for (String x :
                                files) {
                            if (!Objects.equals(x, "null") && x != null)
                                System.out.println(x);
                        }

                        // Types out "-" for clarity
                        System.out.println("----------------");
                        continue;
                    }
                    case 5 -> {

                        // Deletes file

                        // Clears
                        sc.nextLine();

                        System.out.print("Insert file name to be deleted: ");
                        container = sc.nextLine();

                        // Checks file extension
                        if (checkingExtension.check(container)) {

                            // Prevents deleting whole array and all files
                            if (container.equals("") || container.equals("numbers.txt")) {
                                System.out.println("You cannot delete that file!");
                                continue;
                            }
                        } else {
                            System.out.println("Wrong file extension");
                            continue;
                        }

                        // Deletes file from directory and from array
                        for (int i = 0; i < files.length; i++) {
                            if (Objects.equals(files[i], container)) {
                                FileManager.deleteFile(files[i]);
                                files[i] = "null";
                                FileWriter.write(files);
                                System.out.println("File " + container + " deleted");
                                break;
                            }
                        }

                        // Types out "-" for clarity
                        System.out.println("----------------");
                        continue;
                    }
                    case 6 -> {
                        // Creates file

                        System.out.print("Enter a name of the file to be created: ");
                        sc.nextLine();

                        container = sc.nextLine();

                        // Checks if file extension is correct
                        if (checkingExtension.check(container)) {

                            // Creates file
                            FileManager.createFile("src/main/resources/" + container);
                            System.out.println("File: " + container + " created");
                            FileManager.setFileName(container);
                            System.out.println("Current path: " + FileManager.getFileName());

                            // Forces user to do not leave file empty
                            set = true;
                            choice = 2;

                            // Saves file's name in file
                            files[++k] = container;
                            FileWriter.write(files);
                        } else
                            System.out.println("Wrong file extension");

                        continue;
                    }
                    case 7 -> {
                        // Shows current path
                        System.out.println("Current path is: " + FileManager.getFileName());
                        continue;
                    }
                    case 8 -> {
                        // Responsible for exiting program
                        exit = true;
                        continue;
                    }
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

                    if (notCreated) {
                        // Tells user everything went fine
                        System.out.println("All numbers sorted\nYou can see them in file " + FileManager.getFileName() + " or see them now by clicking 1 ([2] to exit):");
                        choice = sc.nextInt();

                        // Optionally shows numbers
                        if (choice == 1) {

                            // Creates array
                            int[] db2;

                            // Assigns array
                            db2 = rd.read(rd.howMany());

                            // Types out "-" for clarity
                            System.out.println("----------------");

                            // Prints out array
                            for (int x :
                                    db2) {
                                System.out.println(x);
                            }

                            // Types out "-" for clarity
                            System.out.println("----------------");
                        }
                    }
                } else {
                    System.out.println("File is empty use terminal first!");
                }
            }catch(InputMismatchException e){
                System.out.println("Wrong character inserted");
            }
        }while (!exit);

        // Says goodbye
        System.out.println("See you!");
    }
}