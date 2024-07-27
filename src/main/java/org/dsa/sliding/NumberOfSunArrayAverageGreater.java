package org.dsa.sliding;

public class NumberOfSunArrayAverageGreater {

    //Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.
    //
    //Example 1:
    //Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
    //Output: 3
    //Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).

    public static void main(String[] args) {
        int[] arr ={11,13,17,23,29,31,7,5,2,3};
        System.out.println(numOfSubarrays(arr,3,5));

    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int answer = 0;
        if(arr.length == 0){
            return answer;
        }
        int wsum = 0;
        for (int i =0; i< k; i++){
            wsum += arr[i];
        }
        if(wsum / k >= threshold){
            answer++;
        }
        for(int i = k ; i< arr.length ; i++){
            wsum = wsum - arr[i-k] + arr[i];
            if(wsum / k >= threshold){
                answer++;
            }
        }
        return answer;
    }
}
