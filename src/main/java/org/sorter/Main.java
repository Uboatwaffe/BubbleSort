package org.sorter;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        Reading rd = new Reading();
        int counter = rd.howMany();
        if (counter > 0) {
            int[] db;
            db = rd.read(counter);
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