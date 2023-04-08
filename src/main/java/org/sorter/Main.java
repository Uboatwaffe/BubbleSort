package org.sorter;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        Reading rd = new Reading();
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
        Writing writer = new Writing();

        int counter = rd.howMany();
        if (counter > 0) {
            int[] db;
            db = rd.read(counter);
            db = sorter.sort(db);
            String[] sorted = pa.parse(db);

            writer.write(sorted);
        }
    }
}