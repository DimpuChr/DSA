package org.dsa.strings;

public class GCDStr {

    public static String gcdOfStrings(String str1, String str2) {
        // Step 1: Check if str1 + str2 is equal to str2 + str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Step 2: Find the GCD of the lengths of the two strings
        int gcdLength = gcd(str1.length(), str2.length());

        // Step 3: The GCD string is the substring from 0 to gcdLength of str1
        return str1.substring(0, gcdLength);
    }

    // Helper method to compute the GCD of two integers
    private static int gcd(int a, int b) {
        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        // Example 1
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "ABC"

       /* // Example 2
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "AB"

        // Example 3
        String str1 = "LEET";
        String str2 = "CODE";
        System.out.println(gcdOfStrings(str1, str2)); // Output: ""*/
    }
}
