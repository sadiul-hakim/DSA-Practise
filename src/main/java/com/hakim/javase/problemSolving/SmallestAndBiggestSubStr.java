package com.hakim.javase.problemSolving;

/**
 *
 * @author Hakim
 */
public class SmallestAndBiggestSubStr {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        int i = 0;
        while (i < s.length()) {
            for (int j = i; j < s.length(); j++) {
                if (k + j <= s.length()) {
                    String currentString = s.substring(j, k + j);
                    if (currentString.compareTo(largest) > 0) {
                        largest = currentString;
                    }

                    if (currentString.compareTo(smallest) < 0) {
                        smallest = currentString;
                    }
                }
            }
            i++;
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        String smallestAndLargest = getSmallestAndLargest("welcometojava", 3);
        System.out.println(smallestAndLargest);
    }
}
