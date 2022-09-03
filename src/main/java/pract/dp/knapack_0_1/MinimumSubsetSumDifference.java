package pract.dp.knapack_0_1;

import java.util.ArrayList;

public class MinimumSubsetSumDifference {

    //using Matrix
    static ArrayList<Integer> findAllSubSetInGivenRange(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        ArrayList<Integer> al = new ArrayList();
        //considering last row and half elements

        for (int j = 0; j < sum + 1; j++) {
            if (t[n][j]) {
                System.out.print(j + " ");
            }
        }

        for (int j = 0; j < sum / 2; j++) {
            if (t[n][j]) {
                al.add(j);
            }
        }
        return al;
    }


    static int findMinimumSubSet(int[] arr, int n) {
        int range = 0;
        for (int i : arr) range += i;

        // Now will get the S1
        ArrayList<Integer> al = findAllSubSetInGivenRange(arr, range, n);

        // Need to find s2-s1
        // if i will get s1 then s2 will ne range-s1 so that is = range-s1-s1 =  range-2*s1

        int min = Integer.MAX_VALUE;
        for (int i : al) {
            min = Math.min(min, range - 2 * i);
        }

        return min;

    }

    public static void main(String[] args) {
//        int[]arr = {44, 7, 12, 43, 30, 24, 22, 20, 35, 38, 49, 25, 16, 21, 14, 27, 42, 31};
        int[] arr = {1, 6, 7};
        findMinimumSubSet(arr, arr.length);

    }
}
