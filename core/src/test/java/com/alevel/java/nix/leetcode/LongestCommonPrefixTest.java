package com.alevel.java.nix.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    private String[] strings;

    @BeforeEach
    private void setLongestCommonPrefix() {
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @Test
    public void shouldReturnEmptyString() {
        strings = new String[]{"", "", " "};
        assertEquals("", longestCommonPrefix.longestCommonPrefix(strings));

        strings = new String[]{};
        assertEquals("", longestCommonPrefix.longestCommonPrefix(strings));

        strings = null;
        assertEquals("", longestCommonPrefix.longestCommonPrefix(strings));
    }

    @Test
    public void shouldReturnCorrect() {
        strings = new String[]{"aAabcD", "aAA"};
        assertEquals("aA", longestCommonPrefix.longestCommonPrefix(strings));

        strings = new String[]{"a", "b", "c", "d"};
        assertEquals("", longestCommonPrefix.longestCommonPrefix(strings));

        strings = new String[]{"my name is", "my name"};
        assertEquals("my name", longestCommonPrefix.longestCommonPrefix(strings));

        strings = new String[]{Integer.toString(123), Integer.toString(1234)};
        assertEquals("123", longestCommonPrefix.longestCommonPrefix(strings));
    }
}