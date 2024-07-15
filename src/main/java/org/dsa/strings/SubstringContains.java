package org.dsa.strings;

public class SubstringContains {

    public static void main(String[] args) {

        String s = "dardarshankumarrahul";
        String substring = "darshan";

        // Call custom method to check if substring exists
        if (isSubstring(s, substring)) {
            System.out.println(substring + " exists in " + s);
        } else {
            System.out.println(substring + " does not exist in " + s);
        }

    }

    // Custom method to check if substring exists in string
    public static boolean isSubstring(String s, String substring) {
        int n = s.length();
        int m = substring.length();

        // Iterate through the main string
        for (int i = 0; i <= n - m; i++) {

            int k = 0;
            // Check if substring matches starting from position i in main string
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != substring.charAt(j)) {
                    break;
                }
                k++;
            }

            // If substring matches completely, return true
            if (k == m) {
                return true;
            }
        }

        // If substring is not found, return false
        return false;
    }
}
