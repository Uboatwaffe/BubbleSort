package org.sorter;

public class CheckingExtension {

    // This method checks if file extension is correct
    protected boolean check(String fileName){
        // If file is to shor to be correct returns false
        if (fileName.length() < 5)
            return false;

        // Checks if the extension is correct if so returns true
        if (fileName.charAt(fileName.length()-4) == '.'){
            if (fileName.charAt(fileName.length()-3) == 't'){
                if (fileName.charAt(fileName.length()-2) == 'x'){
                    return fileName.charAt(fileName.length() - 1) == 't';
                }
            }
        }

        // If file extension is not correct returns false
        return false;
    }
}
