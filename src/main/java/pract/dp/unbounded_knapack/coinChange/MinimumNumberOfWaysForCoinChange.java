package pract.dp.unbounded_knapack.coinChange;

// Minimum number of ways to make it sum from coins

/**
 * Array - [1,2,3] coins and make sum = 5 using these coins.
 * Note: problem is same as subset sum of unbounded knapsack
 */
public class MinimumNumberOfWaysForCoinChange {

    //This is using recursion, Try to do it using table like already done in subset sum problem
   static int find(int[] arr, int sum, int n) {
        if (n == 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if (arr[n - 1] > sum) {
            return find(arr, sum, n - 1);
        }
        return find(arr, sum - arr[n - 1], n) + find(arr, sum, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,6};
       int sum = 10;
       System.out.println(find(arr , sum , arr.length));
    }
}
