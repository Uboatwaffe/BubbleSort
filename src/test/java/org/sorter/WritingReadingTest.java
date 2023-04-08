package org.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritingReadingTest {
    Writing writing = new Writing("src/test/resources/test.txt");
    Reading reading = new Reading("src/test/resources/test.txt");

    @Test
    void test() {

    // Arrays
    // Set 1
    String[] db1 = {"3", "5", "2", "-43"};
    int[] db11 = {3,5,2,-43};

    // Set 2
    String[] db2 = {"2", "0", "9", "21","11"};
    int[] db22 = {2,0,9,21,11};

    // Set 3
    String[] db3 = {"55", "12", "-12"};
    int[] db33 = {55,12,-12};

    // Test 1
    writing.write(db1);
    assertArrayEquals(db11, reading.read(4));

    // Test 2
    writing.write(db2);
    assertArrayEquals(db22, reading.read(5));

    // Test 3
    writing.write(db3);
    assertArrayEquals(db33, reading.read(3));
    }
}