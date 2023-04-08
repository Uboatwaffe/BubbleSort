package org.sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new File("src/main/resources/numbers.txt"))){
            while(sc.hasNextInt()){
                System.out.println(sc.nextInt());
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}