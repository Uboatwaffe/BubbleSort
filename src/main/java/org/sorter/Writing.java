package org.sorter;

import java.io.FileWriter;
import java.io.IOException;

public class Writing{
    String fileName = "src/main/resources/numbers.txt";
    int j;
    protected void write(String[] a) {

        // Writing String[] in file
        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 0; i < a.length-1; i++) {
                fw.write(a[i] + "\n");
                j = i;
            }
            fw.write(a[++j]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
