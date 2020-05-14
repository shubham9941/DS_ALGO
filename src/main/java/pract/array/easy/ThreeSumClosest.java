package pract.array.easy;

import java.util.Arrays;

public class ThreeSumClosest {

    static void printThreeSum(int[] arr, int size, int n) {
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < size - 2; i++) {
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (Math.abs((n - sum)) < Math.abs((n - closestSum))) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    closestSum = sum ;
                    k--;
                } else if (sum > n) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {-7, 9, 8, 3, 1, 1};
//        int[] arr = {5, 2, 7, 5};
        printThreeSum(arr, arr.length, 2);

    }
}
