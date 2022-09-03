package pract.array.easy;

import pract.Reader;

//Note - Very Imp

public class SpirallyTraversingMatrix {

    static void printSpirallyMatrix(int[][] arr, int iStart, int jStart, int m, int n, String turn, boolean pos, StringBuilder sb) {
        if (iStart <= m && jStart <= n) {
            if (turn == "j") {
                if (pos) {
                    int i = jStart;
                    while (i <= n) {
                        sb.append(arr[iStart][i] + " ");
//                        System.out.println(arr[iStart][i]);
                        i++;
                    }
                    printSpirallyMatrix(arr, iStart + 1, jStart, m, n, "i", true, sb);
                } else {

                    int i = n;
                    while (i >= jStart) {
                        sb.append(arr[m][i] + " ");
//                        System.out.println(arr[m][i]);
                        i--;
                    }
                    printSpirallyMatrix(arr, iStart, jStart, m - 1, n, "i", false, sb);
                }
            } else {
                if (pos) {
                    int i = iStart;
                    while (i <= m) {
                        sb.append(arr[i][n] + " ");
//                        System.out.println(arr[i][n]);
                        i = i + 1;
                    }
                    printSpirallyMatrix(arr, iStart, jStart, m, n - 1, "j", false, sb);
                } else {
                    int i = m;
                    while (i >= iStart) {
                        sb.append(arr[i][jStart] + " ");
//                        System.out.println(arr[i][jStart]);
                        i--;
                    }
                    printSpirallyMatrix(arr, iStart, jStart + 1, m, n, "j", true, sb);
                }
            }

        } else {
            System.out.println(sb);
        }
    }

    static void simple(int[][] arr, int startRow, int endRow, int startCol, int endCol) {
        if (!(startRow > endRow || startCol > endCol)) {
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(arr[startRow][j] + " ");
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(arr[i][endCol] + " ");
            }
            if (startRow != endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    System.out.print(arr[endRow][j] + " ");
                }
            }
            if (startCol != endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    System.out.print(arr[i][startCol] + " ");
                }
            }

            simple(arr, startRow + 1, endRow - 1, startCol + 1, endCol - 1);
        }
    }

    public static void main(String[] args) throws Exception {

//        Reader sc = new Reader();
//        int testCases = sc.nextInt();
//        while (testCases-- > 0) {
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            int[][] arr = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    arr[i][j] = sc.nextInt();
//                }
//            }
//            printSpirallyMatrix(arr, 0, 0, m - 1, n - 1, "j", true, new StringBuilder());
//        }

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        simple(arr, 0, 2, 0, 2);

    }
}
