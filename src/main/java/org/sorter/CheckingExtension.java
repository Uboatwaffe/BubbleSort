package org.sorter;

public class CheckingExtension {

    protected boolean check(String fileName){
        if (fileName.length() < 5)
            return false;
        if (fileName.charAt(fileName.length()-4) == '.'){
            if (fileName.charAt(fileName.length()-3) == 't'){
                if (fileName.charAt(fileName.length()-2) == 'x'){
                    return fileName.charAt(fileName.length() - 1) == 't';
                }
            }
        }
        return false;
    }
}
