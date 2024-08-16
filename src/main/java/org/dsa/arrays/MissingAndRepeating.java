package org.dsa.arrays;

public class MissingAndRepeating {

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 7, 8, 2, 1, 5}; // Example input

        findMissingAndRepeating(array);
    }

    public static void findMissingAndRepeating(int[] nums) {
        int n = nums.length;
        long expectedSum = n * (n + 1) / 2;
        long expectedSumOfSquares = n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSumOfSquares = 0;

        for (int num : nums) {
            actualSum += num;
            actualSumOfSquares += (long) num * num;
        }

        long sumDiff = expectedSum - actualSum;
        long sumOfSquaresDiff = expectedSumOfSquares - actualSumOfSquares;

        // The sum of the repeating and missing numbers
        long repeatingPlusMissing = sumOfSquaresDiff / sumDiff;

        // Find the missing and repeating numbers
        int missing = (int) ((repeatingPlusMissing + sumDiff) / 2);
        int repeating = (int) (missing - sumDiff);

        System.out.println("Missing Number: " + missing);
        System.out.println("Repeating Number: " + repeating);
    }
}
