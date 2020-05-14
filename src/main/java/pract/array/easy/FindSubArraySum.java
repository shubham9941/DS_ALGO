package pract.array.easy;

import java.util.HashMap;

// #AMAZON, #FB, #GOOGLE

// Find all sub array that can produce equal sum
/*
Example:-

{100, 200, 2, 3, 4, 1, 300} for sum = 5

Then sub array will be -> {2,3} and {4,1} so there is 2 set


*/

public class FindSubArraySum {

    // Function to find number of subarrays
    // with sum exactly equal to k.
    static int findSubarraySum(int arr[], int n, int sum) {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        // Sum of elements so far.
            int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }
        System.out.println(prevSum);

        return res;
    }


    public static void main(String[] args) {

        int arr[] = {100, 200, 2, 3, 4, 1, 300};
        int sum = 5;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}

