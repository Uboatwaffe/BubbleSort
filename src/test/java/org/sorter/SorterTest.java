package org.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    Sorter sorter = new Sorter();

    @Test
    void sort() {
        // Arrays
        // Set 1
        int[] db1 = {3, 5, 2, -43};
        int[] db12 = {-43, 2, 3, 5};

        // Set 2
        int[] db2 = {11, -65, -6, 2, 1};
        int[] db22 = {-65, -6, 1, 2, 11};

        // Set 3
        int[] db3 = {9754, -131, -355, -12, 0};
        int[] db33 = {-355, -131, -12, 0 , 9754};

        // Test 1
        assertArrayEquals(db12, sorter.sort(db1));

        // Test 2
        assertArrayEquals(db22, sorter.sort(db2));

        // Test 3
        assertArrayEquals(db33, sorter.sort(db3));
    }
}