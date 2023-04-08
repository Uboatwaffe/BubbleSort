package org.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadingTest {
    Reading reading = new Reading("src/test/resources/test.txt");

    // Array
    int[] db = {12,45,-34,12,0,-45};

    @Test
    void howMany() {
        assertEquals(6, reading.howMany());
    }

    @Test
    void read() {
        assertArrayEquals(db, reading.read(6));
    }
}