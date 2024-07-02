package org.dsa.recursion.easy;

public class CountNumZeros {

    static int count = 0;
    public static void main(String[] args) {
        int num = 30204;
        countZeros(num);
        System.out.println(count);
        System.out.println(getCount(num,0));
    }


    static void countZeros(int num){
        if(num == 0){
            return;
        }
        int remiander = num % 10;
        if(remiander == 0){
            count++;
        }
        countZeros(num/10);
    }

    static int getCount(int num , int count){
        if( num == 0){
            return count;
        }
        int remainder = num % 10;
        if( remainder == 0){
            return getCount(num/10, count+1);
        }
        return getCount(num/10, count);
    }
}
