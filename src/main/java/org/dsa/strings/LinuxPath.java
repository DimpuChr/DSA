package org.dsa.strings;

import java.util.Stack;

public class LinuxPath {
    public static void main(String[] args) {

        String s= "/../";
        String[] split = s.split("/");

        Stack<String> s1 = new Stack<>();
        for (String part : split){
            if(part.equals("..") ){
                s1.pop();
            } else if (!part.equals(".") && !part.isEmpty()) {
                s1.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String ss : s1){
            sb.append("/").append(ss);
        }


        System.out.println(sb.toString());
    }
}
