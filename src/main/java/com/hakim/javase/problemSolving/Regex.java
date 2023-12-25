package com.hakim.javase.problemSolving;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hakim
 */
public class Regex {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine().trim();
//
//        if (!s.isEmpty()) {
//            String[] sArray = s.split("[^A-Za-z0-9]+");
//
//            System.out.println(sArray.length);
//
//            for (String temp : sArray) {
//                System.out.println(temp);
//            }
//        } else {
//            System.out.println("0");
//        }
//
//        scan.close();
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int testCases = Integer.parseInt(in.nextLine());
//        while (testCases > 0) {
//            String pattern = in.nextLine();
//
//            try {
//                Pattern.compile(pattern);
//                System.out.println("Valid");
//            } catch (Exception ex) {
//                System.out.println("Invalid");
//            }
//        }
//    }
    public static void extractContent(String s) {

        // Regular expression to match HTML-like tags and their content.
        String regex = "<(.+)>([^<]+)</\\1>";
        // Compile the regular expression into a Pattern.
        Pattern pat = Pattern.compile(regex);
        // Create a Matcher to find matches in the input string.
        Matcher mat = pat.matcher(s);
        // Initialize a boolean flag to check if any matches were found.
        Boolean found = false;

        // Loop through the string and find all matches.
        while (mat.find()) {
            // Print the content inside the matched tags (group(2)).
            System.out.println(mat.group(2));
            // Set the found flag to true, since we found at least one match.
            found = true;
        }

        // If no matches were found, print "None".
        if (!found) {
            System.out.println("None");
        }
    }

    public static void main(String[] args) {
        // Create a Scanner to read input from the console.
        Scanner input = new Scanner(System.in);
        // Read the number of lines to process.
        int numOfLines = Integer.parseInt(input.nextLine());

        // Iterate through the specified number of lines.
        for (int i = 0; i < numOfLines; i++) {
            // Read a line of input.
            String s = input.nextLine();
            // Call the `extractContent` method to process the input string.
            extractContent(s);
        }
    }
}
