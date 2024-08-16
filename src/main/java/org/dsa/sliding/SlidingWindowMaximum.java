package org.dsa.sliding;

import java.util.*;

public class SlidingWindowMaximum {
    //You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    // You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    //Return the max sliding window.
    //Example 1:
    //
    //Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    //Output: [3,3,5,5,6,7]
    //Explanation:
    //Window position                Max
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow1(arr,3)));
    }


    //using proprity queue
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] answer = new int[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            // Add current element to the heap
            maxHeap.add(nums[i]);

            // Remove the element that is out of the current window
            if (i >= k) {
                maxHeap.remove(nums[i - k]);
            }

            // Once we've processed the first k elements, record the maximum
            if (i >= k - 1) {
                answer[i - k + 1] = maxHeap.peek();
            }
        }

        return answer;
    }

    //using deque

    public static int[] maxSlidingWindow1(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;

    }
}
