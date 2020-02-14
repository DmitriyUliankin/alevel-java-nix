package com.alevel.java.nix.leetcode;

public class ReverseCharSequence implements CharSequence {

    private CharSequence original;

    public ReverseCharSequence(CharSequence original) {
        this.original = original;
    }

    public int reversedIndex(int index) {
        int lastIndex = original.length() - 1;
        return lastIndex - index;
    }

    public CharSequence getReverseCharSequence(CharSequence string) {
        if (string == null) {
            return null;
        }
        return new ReverseCharSequence(string);
    }

    @Override
    public int length() {
        return original.length();
    }

    @Override
    public char charAt(int index) {
        return original.charAt(original.length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int originalEnd = original.length() - start;
        int originalStart = original.length() - end;
        return new ReverseCharSequence(
                original.subSequence(originalStart, originalEnd));
    }

    @Override
    public String toString() {
        return new StringBuilder(this).toString();
    }
}
