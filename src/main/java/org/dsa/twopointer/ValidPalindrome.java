package org.dsa.twopointer;

public class ValidPalindrome {

    //A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
    // it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    //
    //Given a string s, return true if it is a palindrome, or false otherwise.
    //Example 1:
    //
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.

    public static void main(String[] args) {

        String s= "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String lowerCase = sb.toString();
        if(lowerCase.length()==1){
            return true;
        }
        int start =0;
        int end = lowerCase.length()-1;
        while (start< end){
            if(lowerCase.charAt(start) != lowerCase.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
