package org.dsa.strings;

public class ReverseWordsinaStringIII {

    //Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "Let's take LeetCode contest"
    //Output: "s'teL ekat edoCteeL tsetnoc"

    public static void main(String[] args) {
        String s= "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if(s.length() ==0 || s.length() ==1){
            return s;
        }

        char[] charArray = s.toCharArray();
        int start =0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ' ' || i == charArray.length-1){
                int end = (i == charArray.length-1 && charArray[i] != ' ') ? i+1 : i;
                while (start < end){
                    char temp = charArray[start];
                    charArray[start] = charArray[end-1];
                    charArray[end-1] = temp;
                    start++;
                    end--;
                }
                start = i+1;
            }
        }
        return new String(charArray);

    }
}
