package org.dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    //Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
    //
    //
    //
    //Example 1:
    //
    //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]
    //Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    public static void main(String[] args) {

        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(arr));
    }

    public static int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        if(intervals.length ==0 || intervals == null){
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] arr : intervals){

            if(arr[0] <= end){
                end = Math.max(end, arr[1]);
            }else{
                res.add(new int[]{start,end});
                start = arr[0];
                end = arr[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}
