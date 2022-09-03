package pract.dp.pract.hard;

import pract.Reader;

import java.util.ArrayList;

public class MinimumSumPartition {

    static ArrayList<Integer> findAllSubsetOfGivinRange(int[] arr, int n, int sum) {

        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = j == 0;
                } else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int j = 0; j <= sum / 2; j++) {
            if (t[n][j]) {
                al.add(j);
            }
        }
        return al;
    }

    static int getMinDiff(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) sum += i;

        ArrayList<Integer> al = findAllSubsetOfGivinRange(arr, n, sum);

        int min = Integer.MAX_VALUE;
        for (int s1 : al) {
            min = Math.min(min, sum - 2 * s1);
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getMinDiff(arr,size));
        }
    }
}
