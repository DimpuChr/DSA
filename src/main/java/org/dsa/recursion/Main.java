package org.dsa.recursion;

public class Main {

    public static void main(String[] args) {

        message(5);
    }
    static void message(int i){
        if(i == 0){
            return;
        }
        System.out.println("HIiiii");
        message(i-1);
    }
}
