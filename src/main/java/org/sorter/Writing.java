package org.sorter;

import java.io.FileWriter;
import java.io.IOException;

public class Writing{
    private String FileName;
    Writing(String path){
        FileName = path;
    }
    protected void write(String[] a) throws NullPointerException {

        // Writing String[] in file
        try (FileWriter fw = new FileWriter(FileName)) {
            for (int i = 0; i < a.length; i++) {
                fw.write(a[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
