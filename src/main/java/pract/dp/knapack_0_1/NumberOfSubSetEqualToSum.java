package pract.dp.knapack_0_1;

// This problem is same as FindSubSetSumEqualToSum, here instead of returning T/F we will return number of subsets
public class NumberOfSubSetEqualToSum {

    // recursion approach and we can also use matrix
   static int findNumberOfSubSet(int[] arr, int sum, int n) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (arr[n - 1] > sum) {
            return findNumberOfSubSet(arr, sum, n - 1);
        }
        return (findNumberOfSubSet(arr, sum - arr[n - 1], n - 1) + findNumberOfSubSet(arr, sum, n - 1));
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};

        System.out.println(findNumberOfSubSet(arr , 10, arr.length));

    }
}
