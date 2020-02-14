package com.alevel.java.nix.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseCharSequenceTest {

    private String string = "";
    private ReverseCharSequence charSequence = new ReverseCharSequence(string);

    @Test
    public void charSequenceTest() {
        testIntegers(string);
        testString(string);
        testNull(string);
    }

    private void testIntegers(String string) {
        string = Integer.toString(0);
        assertEquals(string, charSequence.getReverseCharSequence("0").toString());

        string = Integer.toString(12345);
        assertEquals(string, charSequence.getReverseCharSequence("54321").toString());
    }

    private void testString(String string) {
        string = "a";
        assertEquals(string, charSequence.getReverseCharSequence("a").toString());

        string = "dcba";
        assertEquals(string, charSequence.getReverseCharSequence("abcd").toString());

        string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals(string, charSequence.getReverseCharSequence("ZYXWVUTSRQPONMLKJIHGFEDCBA").toString());
    }

    private void testNull(String string) {
        assertEquals(string, charSequence.getReverseCharSequence("").toString());

        string = " ";
        assertEquals(string, charSequence.getReverseCharSequence(" ").toString());

        string = null;
        assertNull(charSequence.getReverseCharSequence(string));
    }
}