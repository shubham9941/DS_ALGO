package pract.dp.pract.medium;

import java.util.Arrays;

public class UniquePartitions {

    static int get(int[] arr, int n, int sum) {

        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (arr[n - 1] > sum) {
            return get(arr, n - 1, sum);
        }

        return get(arr, n, sum - arr[n - 1]) + get(arr, n - 1, sum);
    }

    static int getUsingDP(int[] arr, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = (j == 0) ? 1 : 0;
                } else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i][j - arr[i - 1]] + t[i - 1][j];
                }
            }
        }

        for(int[]ar : t){
            System.out.println(Arrays.toString(ar));
        }

        return t[n][sum];
    }

    public static void main(String[] args) {

//        int n = 3;
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++)
//            arr[i] = i + 1;
//
//        System.out.println(get(arr, n, n));
        int[] arr = {1,2,3,4};
        System.out.println(getUsingDP(arr, arr.length, 4));

    }
}
