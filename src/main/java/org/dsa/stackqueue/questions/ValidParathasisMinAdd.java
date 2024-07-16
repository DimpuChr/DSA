package org.dsa.stackqueue.questions;

import java.util.Stack;

public class ValidParathasisMinAdd {

    public int minAddToMakeValid(String s){

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){

            if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
            stack.push(ch);
        }
        return stack.size();
    }
}
