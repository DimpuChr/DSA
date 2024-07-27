package org.dsa.sliding;

public class MaxSumSubArrayK {

    /*static int max_sum_of_subarray(int arr[], int n, int k)
    {
        int max_sum = 0;
        for (int i = 0; i + k <= n; i++) {
            int temp = 0;
            for (int j = i; j < i + k; j++) {
                temp += arr[j];
            }
            if (temp > max_sum)
                max_sum = temp;
        }

        return max_sum;
    }*/
    public static void main(String[] args)
    {
        int arr[] = { 15, 4, 2, 10, 8 };
        int k = 2;
        int n = arr.length;

        // by brute force
        int max_sum = max_sum_of_subarray(arr, n, k);
        System.out.println(max_sum);

        System.out.println("sliding window technique");
        System.out.println(slidingWindow(arr,n,k));
    }
    static int max_sum_of_subarray(int[] arr, int length, int k){
        int max_sum = 0;
        for (int i = 0; i+k <= length ; i++) {
            int temp =0;
            for (int j = i; j < i+k; j++) {
                temp += arr[j];
            }
            max_sum = Math.max(max_sum,temp);
        }
        return max_sum;
    }

    static int slidingWindow(int[] arr, int length, int k){
        int wSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            wSum += arr[i];
        }
        maxSum = Math.max(wSum,maxSum);
        for (int i = k; i < length; i++) {
            wSum = wSum - arr[i-k] + arr[i];
            maxSum = Math.max(wSum,maxSum);
        }
        return maxSum;
    }
}

