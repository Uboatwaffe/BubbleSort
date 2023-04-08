package org.sorter;

import static org.junit.jupiter.api.Assertions.*;

class ParsingTest {
    Parsing parsing = new Parsing();

    @org.junit.jupiter.api.Test
    void parse() {

        // Arrays
        int[] db = new int[10];
        String[] sb = new String[10];

        // Variables
        int k = 0;

        // Loop for higher numbers
        for (int l = 0; l < 10000; l++) {
            for (int i = 0; i < 10000; i++, k += 10) {

                // Creating new int array
                for (int j = 0; j < db.length; j++, k++) {
                    db[j] = k;
                }

                // Parsing array to String array
                for (int j = 0; j < db.length; j++) {
                    sb[j] = Integer.toString(db[j]);
                }
                assertArrayEquals(sb, parsing.parse(db));
            }
        }
    }
}