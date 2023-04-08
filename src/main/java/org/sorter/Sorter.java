package org.sorter;

public class Sorter {
    int c;
    protected int[] sort(int[] a){

        // Sorting int[] from smallest to biggest
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j+1]){
                    c = a[j];
                    a[j] = a[j+1];
                    a[j+1] = c;
                }
            }
        }
        return a;
    }
}
