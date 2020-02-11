package com.alevel.java.nix.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringTest {

    private Substring substring = new Substring();

    @Test
    void getUniqueCharacterSubstring() {
        assertEquals("", substring.getUniqueCharacterSubstring(""));
        assertEquals("1A", substring.getUniqueCharacterSubstring("1AA"));
        assertEquals("ABCDEF", substring.getUniqueCharacterSubstring("AABCDEF"));
        assertEquals("ABCDEF", substring.getUniqueCharacterSubstring("ABCDEFF"));
        assertEquals("NGISAWE", substring.getUniqueCharacterSubstring("CODINGISAWESOME"));
        assertEquals("be coding", substring.getUniqueCharacterSubstring("always be coding"));
    }
}