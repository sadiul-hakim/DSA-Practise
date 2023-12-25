package com.hakim.javase.problemSolving;

import java.util.Scanner;

/**
 *
 * @author Hakim
 */
public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int i = 0;
        boolean isPalindrome = true;

        while (i < A.length()) {
            if (A.charAt(i) != (A.charAt(A.length() - i - 1))) {
                isPalindrome = false;
                break;
            }
            i++;
        }

        if (isPalindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
