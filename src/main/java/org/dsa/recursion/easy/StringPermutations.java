package org.dsa.recursion.easy;

public class StringPermutations {
    public static void main(String[] args) {

        String str = "abc";
        printPerm(str, "");
    }

    public static void printPerm(String newstr, String combination){
        if(newstr.length() == 0){
            System.out.println(combination);
            return;
        }

        for (int i = 0; i < newstr.length() ; i++) {
            char currentChar = newstr.charAt(i);
            String str = newstr.substring(0,i) + newstr.substring(i+1);
            printPerm(str, combination + currentChar );
        }
    }
}
