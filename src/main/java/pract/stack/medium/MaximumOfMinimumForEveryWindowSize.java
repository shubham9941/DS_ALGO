package pract.stack.medium;

import pract.Reader;

public class MaximumOfMinimumForEveryWindowSize {

    private static void printMaxValueByWindow(int[][] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                if (arr[j - i][j] > max)
                    max = arr[j - i][j];
            }
            sb.append(max + " ");
        }
        System.out.println(sb);
    }

    //This method is using Dynamic programing using o(n^2) // But giving the heap memory error. Possible solution is using stack
    static void fillValues(int[][] arr, int n) {
        for (int k = 1; k < n; k++) {
            int r = 0;
            for (int j = k; j < n; j++) {
                arr[r][j] = ((arr[r][j - 1] < arr[r + 1][j]) ? arr[r][j - 1] : arr[r + 1][j]);
                r++;
            }
        }
        printMaxValueByWindow(arr, n);
    }

    public static void main(String[] args) throws Exception {

        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[][] array = new int[size][size];
            for (int i = 0; i < size; i++) {
                array[i][i] = sc.nextInt();
            }
            fillValues(array, size);
        }
    }
}
