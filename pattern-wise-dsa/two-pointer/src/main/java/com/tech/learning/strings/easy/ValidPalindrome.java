package com.tech.learning.strings.easy;

/**
 * Question: https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {

    static void main() {
        String str = "A man, a plan, a canal: Panama";

        boolean bruteResult = isPalindromeBruteForceApproach(str);
        System.out.println(STR."Brute-Force -- valid palidrome: \{bruteResult}");

        boolean optimalResult = isPalindromeOptimalApproach(str);
        System.out.println(STR."Optimal Approach -- valid palidrome: \{optimalResult}");
    }

    private static boolean isPalindromeBruteForceApproach(String str) {

        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        String cleanedInputStr = getCleanedString(str);

        StringBuilder outputStr = new StringBuilder();

        for (int i = str.length() - 1; i >= 0 ; i--) {
            char ch = str.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                outputStr.append(Character.toLowerCase(ch));
            }
        }

        if (outputStr.toString().equalsIgnoreCase(cleanedInputStr)) {
            return true;
        }

        return false;
    }


    private static String getCleanedString(String str) {

        StringBuilder cleanedStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleanedStr.append(Character.toLowerCase(ch));
            }
        }

        return cleanedStr.toString();
    }

    private static boolean isPalindromeOptimalApproach(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            } else if (!Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            } else {
                if (Character.toLowerCase(str.charAt(j)) != Character.toLowerCase(str.charAt(i))) {
                    return false;
                }

                i++;
                j--;
            }
        }
        return true;
    }
}
