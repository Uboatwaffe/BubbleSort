package org.sorter;

public class Parsing {
    protected String[] parse(int[] a){
        String[] db = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            db[i] = Integer.toString(a[i]);
        }
        return db;
    }
}
