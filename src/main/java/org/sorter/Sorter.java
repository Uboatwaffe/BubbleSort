package org.sorter;


public class Sorter {
    protected int[] sort(int [] a){
        boolean change = false;

        // Sorting int[] from smallest to biggest
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j+1]){
                    int c = a[j];
                    a[j] = a[j+1];
                    a[j+1] = c;
                    change = true;
                }
            }
            // If any change wasn't made exits
            if (!change)
                break;
        }
        return a;
    }
}
