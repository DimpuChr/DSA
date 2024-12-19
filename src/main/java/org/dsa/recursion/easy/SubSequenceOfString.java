package org.dsa.recursion.easy;

public class SubSequenceOfString {

    public static void main(String[] args) {

        String a = "abc";

        subSequence(a,0, "");


    }

    public static void subSequence(String str, int index , String newString){
        if(index == str.length()){
            System.out.println(newString);
            return;

        }

        char currChar = str.charAt(index);
        subSequence(str, index+1 , newString + currChar);

        subSequence(str,index+1,newString);
    }
}
