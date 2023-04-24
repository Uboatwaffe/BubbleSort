package org.sorter;


import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO make interface

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
        Writing writer = null;
        Writing FileWriter = new Writing("src/main/resources/ProgramFiles/files.txt");
        Reading FileReader = new Reading("src/main/resources/ProgramFiles/files.txt");
        Reading rd = null;
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
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
            FileManager.setFileName(container);
        }

        // Sets writer and reader
        writer = new Writing(FileManager.getFileName());
        rd = new Reading(FileManager.getFileName());

        // Checks if FileManager exists
        checker = rd.howMany();
        if (checker == 0) {
            set = true;
            choice = 2;
        } else if (checker == -1) {
            writer = new Writing(defaultPath);
            rd = new Reading(defaultPath);
            System.out.println("Returned to default path: " + defaultPath);
            FileManager.setFileName(defaultPath);
        } else if (checker == -2) {
            files[++k] = container;
        }
        do {
            try {

                if (!set) {

                    // File or manually
                    System.out.print("""
                            
                            Do you want to insert numbers from file (1),
                            via terminal (2),
                            change file (3),
                            show all files (4),
                            delete file (5),
                            or close program (6)?
                            
                            """);
                    choice = sc.nextInt();

                    // Types out "-" for clarity
                    System.out.println("----------------");
                }

                if (choice == 2) {

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

                        writer.write(db);
                    }else{
                        System.out.println("You need at least 2 numbers to be able to sort them");
                    }
                    set = false;
                    notCreated = true;

                }else if (choice == 3) {
                    // Clears
                    sc.nextLine();

                    System.out.print("What new file name is? ");
                    container = sc.nextLine();
                    FileManager.setFileName(container);

                    // Sets writer and reader
                    writer = new Writing(FileManager.getFileName());
                    rd = new Reading(FileManager.getFileName());

                    checker = rd.howMany();

                    if (checker == -1) {
                        writer = new Writing(defaultPath);
                        rd = new Reading(defaultPath);
                        System.out.println("Returned to default path: " + defaultPath);
                        notCreated = false;
                    } else if (checker == -2) {
                        System.out.println("Current path: " + FileManager.getFileName());
                        set = true;
                        choice = 2;
                        files[++k] = container;

                        FileWriter.write(files);

                        continue;
                    } else if (checker > 0) {
                        System.out.println("Current path: " + FileManager.getFileName());
                        continue;
                    } else if (checker == 0) {
                        set = true;
                        choice = 2;
                    }
                } else if (choice == 4) {
                    for (String x:
                         files) {
                        if (!Objects.equals(x, "null") && x != null)
                            System.out.println(x);
                    }
                    // Types out "-" for clarity
                    System.out.println("----------------");
                    continue;
                } else if (choice == 5) {
                    sc.nextLine();
                    System.out.print("Insert file name to be deleted: ");
                    container = sc.nextLine();
                    if (container.equals("") || container.equals("numbers.txt")) {
                        System.out.println("You cannot delete that file!");
                        continue;
                    }
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
                } else if (choice == 6) {
                    exit = true;
                    continue;
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