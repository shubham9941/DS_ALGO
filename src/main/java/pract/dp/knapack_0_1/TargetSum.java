package pract.dp.knapack_0_1;

import pract.dp.knapack_0_1.CountTheNumberOfSubsetWithAGivenDifference;

public class TargetSum {

    // it is same as CountTheNumberOfSubsetWithAGivenDifference.
    // if you assign + and - in every number in array then.
    // it will form 2 sub array s1 with + sign and s2 with - sign. so it is (s1) - (s2) so this prob converted to CountTheNumberOfSubsetWithAGivenDifference

    static int count(int[] arr, int n, int diff) {
       return CountTheNumberOfSubsetWithAGivenDifference.count(arr , n , diff);
    }


    // Another appoach
    static int count(int[] arr, int n, int sum, int calSum) {
        if (n == 0 && calSum == sum) {
            return 1;
        }
        if (n == 0) return 0;

        return (count(arr, n - 1, sum, calSum + arr[n - 1]) + count(arr, n - 1, sum, calSum - arr[n - 1]));
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        System.out.println(count(arr, arr.length, 1));
//        System.out.println(count(arr, arr.length, 1, 0));


    }
}
