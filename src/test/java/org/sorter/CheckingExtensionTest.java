package org.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingExtensionTest {

    @Test
    void check() {
        CheckingExtension checkingExtension = new CheckingExtension();

        String a = "a.txt";
        String b = "txt";
        String c = "1.txt";
        String d = "numbers2.txt";

        assertTrue(checkingExtension.check(a));
        assertFalse(checkingExtension.check(b));
        assertTrue(checkingExtension.check(c));
        assertTrue(checkingExtension.check(d));
    }
}