//package pract.dp.pract.easy;
//
//import pract.Reader;
//
//public class GetMinimumSquares {
//
//    static int getMinSquare(int[] squares, int N, int n, int[][] t) {
//        if (N == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return n;
//        }
//
//        if (N < squares[n - 1]) {
//            return getMinSquare(squares, N, n - 1, t);
////                t[N][n] = getMinSquare(squares, N, n - 1, t);
////                return t[N][n];
//        } else {
//            return 1 + Math.min(
//                    getMinSquare(squares, N - squares[n - 1], n, t),
//                    getMinSquare(squares, N, n - 1, t)
//            );
////                t[N][n] = 1 + Math.min(
////                        getMinSquare(squares, N - squares[n - 1], n, t),
////                        getMinSquare(squares, N, n - 1, t)
////                );
//
////                return t[N][n];
//        }
//
//
//    }
//
//    public static void main(String[] args) throws Exception {
////        Reader sc = new Reader();
////        int testCases = sc.nextInt();
////        while (testCases-- > 0) {
////            int N = sc.nextInt();
////            int[] square = new int[100 + 1];
////            for (int i = 0; i < 100 + 1; i++) {
////                square[i] = i * i;
////            }
////            int[][] t = new int[N + 1][100 + 2];
////            for (int i = 0; i < N + 1; i++) {
////                for (int j = 0; j < 100 + 2; j++) {
////                    t[i][j] = -1;
////                }
////            }
////            System.out.println(getMinSquare(square, N, square.length, t));
////        }
//
//        int a = (int) Math.sqrt(24);
//        System.out.print(a);
//
//
//
//    }
//}
