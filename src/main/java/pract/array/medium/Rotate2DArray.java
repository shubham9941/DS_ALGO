package pract.array.medium;

//Rotate a 2D array without using extra space

import pract.Reader;


public class Rotate2DArray {

    static int s_i = 0;
    static int s_j = 0;

    static void rotateUtil(int[][] arr, int i, int j, int n) {
//        System.out.println("i = " + i + " and j = " + j);
        int rotated_i = j;
        int rotated_j = (n - 1 - i);
        int temp = arr[i][j];
        if (!(rotated_i == s_i && rotated_j == s_j)) {
            rotateUtil(arr, rotated_i, rotated_j, n);

        }
        arr[rotated_i][rotated_j] = temp;
    }

    static void rotate(int[][] arr, int start_row, int end_row, int start_col, int end_col, int n) {
        if (start_col < end_col) {
            for (int j = start_col; j < end_col; j++) {
                s_i = start_row;
                s_j = j;
                rotateUtil(arr, start_row, j, n);
            }
            rotate(arr, start_row + 1, end_row - 1, start_col + 1, end_col - 1, n);
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            rotate(arr, 0, size - 1, 0, size - 1, size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }

    }
}
