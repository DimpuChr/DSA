package org.dsa.stackqueue.questions;

import java.util.Stack;

public class ValidParanthasis {

    //The valid parentheses problem checks if a string of parentheses is balanced,
    // meaning every opening parenthesis has a corresponding closing parenthesis in the correct order

    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else {
                if(c == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
                if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValid1(String s){

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            // If the character is an opening parenthesis, push it onto the stack
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            // If the character is a closing parenthesis, check for a matching opening parenthesis
            else {
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();
                if((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')){
                    return false;
                }
            }
        }
        // If the stack is empty, all parentheses are balanced; otherwise, they are not
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "({[]})";
        System.out.println(isValid(s));
    }
}
