package com.hakim.javase.problemSolving;

import java.util.Arrays;

/**
 *
 * @author Hakim
 */
public class Anagrams {

    static boolean isAnagram2(String a, String b) {
        // Convert strings to lowercase for case-insensitive comparison
        a = a.toLowerCase();
        b = b.toLowerCase();

        // Check if lengths are the same
        if (a.length() == b.length()) {
            // Convert strings to character arrays and sort them
            char[] charArrayA = a.toCharArray();
            char[] charArrayB = b.toCharArray();
            Arrays.sort(charArrayA);
            Arrays.sort(charArrayB);

            // Check if sorted character arrays are equal
            if (Arrays.equals(charArrayA, charArrayB)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    static boolean isAnagram(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() != b.length()) {
            return false;
        }

        String[] aAllChars = a.split("");

        boolean isAnagram = true;
        for (int i = 0; i < aAllChars.length; i++) {
            if (!b.contains(aAllChars[i])) {
                isAnagram = false;
                break;
            }
            b = b.replaceFirst(aAllChars[i], "");
            System.out.println(b);
        }

        return isAnagram;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagramm", "marganaa"));
    }
}
