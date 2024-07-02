package org.dsa.recursion.easy;

public class ConceptIntpass {
    public static void main(String[] args) {
        concept(5);

    }

    static void concept(int num){

        if(num==0){
            return;
        }
        System.out.println(num);
        concept(--num);
    }
}
