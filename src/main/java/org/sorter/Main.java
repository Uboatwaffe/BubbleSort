package org.sorter;


public class Main {
    public static void main(String[] args) {
        // Objects
        Reading rd = new Reading();
        Parsing pa = new Parsing();
        Sorter sorter = new Sorter();
        Writing writer = new Writing();

        // All operations
        writer.write(pa.parse(sorter.sort(rd.read(rd.howMany()))));

    }
}