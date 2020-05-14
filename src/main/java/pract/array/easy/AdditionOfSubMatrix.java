package pract.array.easy;

import pract.Reader;

public class AdditionOfSubMatrix {
    static int addSubMatrix(int[][] arr, int si, int sj, int ei, int ej) {
        int sum = 0;
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                sum = sum + arr[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args)throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int si = sc.nextInt() -1 ;
            int sj = sc.nextInt() - 1;
            int ei = sc.nextInt() - 1;
            int ej = sc.nextInt() - 1;
            System.out.print(addSubMatrix(arr, si, sj, ei, ej));
        }

    }
}
