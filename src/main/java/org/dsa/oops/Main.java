package org.dsa.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    private int rollName;
    private String name;

    public Main(int rollName, String name) {
        this.rollName = rollName;
        this.name = name;
    }

    public static void main(String[] args) {

        int[] arr ={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Initialize the result array with 1 for the multiplication identity
        result[0] = 1;

        // First pass: calculate products of elements to the left of each element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: calculate products of elements to the right of each element
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return result;

    }


}
