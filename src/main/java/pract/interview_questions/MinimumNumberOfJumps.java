package pract.interview_questions;

import java.util.Arrays;

/**
 * Minimum number of jumps to reach end
 * Last Updated: 20-06-2020
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, they cannot move through that element.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 * Explanation: Jump from 1st element
 * to 2nd element as there is only 1 step,
 * now there are three options 5, 8 or 9.
 * If 8 or 9 is chosen then the end node 9
 * can be reached. So 3 jumps are made.
 * <p>
 * Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 * Output: 10
 * Explanation: In every step a jump
 * is needed so the count of jumps is 10.
 */

public class MinimumNumberOfJumps {

    static int find(int[] arr, int start, int end, int[] dp) {
        if (start >= end) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        } else {
            int choice = arr[start];
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= choice; i++) {
                int res = 1 + find(arr, start + i, end, dp);
                if (res < min) {
                    min = res;
                }
            }
            return dp[start] = min;
        }
    }

    static int optimisedFind(int[]arr , int n){
        int[]minJump = new int[n];
        if(arr[0] <= 0){
            return -1;
        }

        minJump[0] = 0;
        int i = 0;
        int j = 1;

        for(; j < n ; j++){
            if(arr[i] + i < j){
                while(arr[i] + i < j)
                    i++;
            }
            if(arr[j-1] > 0){
                minJump[j] = 1 + Integer.min(minJump[j-1] , minJump[i]);
            }
            else if (arr[i] + i >= j){
                minJump[j] = minJump[j] + 1 ;
            }
            else{
                return -1;
            }
        }
        System.out.println(Arrays.toString(minJump));
        return minJump[n-1];
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);

//        System.out.println(find(arr, 0, arr.length - 1, dp));
        System.out.println(optimisedFind(arr,  arr.length));
    }
}
