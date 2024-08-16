package org.dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    //You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    //
    //Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    //
    //Return intervals after the insertion.
    //
    //Note that you don't need to modify intervals in-place. You can make a new array and return it.
    //
    //
    //
    //Example 1:
    //
    //Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    //Output: [[1,5],[6,9]]
    //Example 2:
    //
    //Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //Output: [[1,2],[3,10],[12,16]]
    //Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    public static void main(String[] args) {

        //int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] arr = null;
        int[] arr1 = {4,8};
        System.out.println(Arrays.toString(insert(arr,arr1)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> answer = new ArrayList<>();
        if (intervals == null && newInterval != null) {
            answer.add(new int[]{newInterval[0],newInterval[1]});
            return answer.toArray(new int[0][]);
        }
        if (newInterval.length == 0 || newInterval == null) {
            return intervals;
        }
        if (intervals.length == 0 || intervals == null && newInterval != null) {
            answer.add(new int[]{newInterval[0],newInterval[1]});
            return answer.toArray(new int[0][]);
        }
        int[][] arr = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            arr[i] = new int[2];
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[intervals.length] = newInterval;

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int start = arr[0][0];
        int end = arr[0][1];

        for (int[] value : arr){

            if(value[0] <= end){
                end = Math.max(end , value[1]);
            }else{
                answer.add(new int[]{start,end});
                start = value[0];
                end = value[1];
            }
        }
        answer.add(new int[]{start,end});
        System.out.println(answer);
        return answer.toArray(new int[0][]);

    }

    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> ret = new ArrayList<>();

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ret.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ret.add(newInterval);

        while (i < intervals.length) {
            ret.add(intervals[i]);
            i++;
        }

        return ret.toArray(new int[ret.size()][]);


    }
}
