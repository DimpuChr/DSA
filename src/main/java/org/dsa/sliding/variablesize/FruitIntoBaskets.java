package org.dsa.sliding.variablesize;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {


    //You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
    //
    //You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
    //
    //You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
    //Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
    //Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
    //Given the integer array fruits, return the maximum number of fruits you can pick.
    //
    //
    //
    //Example 1:
    //
    //Input: fruits = [1,2,1]
    //Output: 3
    //Explanation: We can pick from all 3 trees.

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2};

        System.out.println(totalFruit(arr));

    }

    public static int totalFruit(int[] fruits) {

        Map<Integer,Integer> map = new HashMap<>();
        int left= 0;
        int answer = 0;

        for (int right =0 ; right < fruits.length; right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()> 2){
                map.put(fruits[left],map.get(fruits[left]) -1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            answer = Math.max(answer, right-left+1);
        }
        return answer;

    }
}
