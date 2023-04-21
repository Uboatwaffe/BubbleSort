package org.sorter;

import java.io.FileWriter;
import java.io.IOException;

public class Writing{
    private String FileName;
    Writing(String path){
        FileName = path;
    }
    private int j;
    protected void write(String[] a) {

        // Writing String[] in file
        try (FileWriter fw = new FileWriter(FileName)) {
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
