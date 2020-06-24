package pract.graph.medium;

import pract.Reader;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeRequiredToRotAllOranges {

    boolean flag;

    int[] X = {0, 0, -1, 1};
    int[] Y = {-1, 1, 0, 0};
    int MAX_UNIT = 0;

    MinimumTimeRequiredToRotAllOranges() {
        flag = false;
    }

    boolean isValid(int i, int j, int n, int m) {
        if (i >= 0 && i < n  && j >= 0 && j < m ) {
            return true;
        }
        return false;
    }

    class Elem {
        int i;
        int j;

        Elem(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    int getMinUtil(Queue<Elem> qu, int n, int m, int[][] arr) {
        int size = qu.size();
        while (size-- > 0) {
            Elem elem = qu.poll();
            for (int i = 0; i < 4; i++) {
                int x = elem.i + X[i];
                int y = elem.j + Y[i];
                if (isValid(x, y, n, m) && arr[x][y] == 1) {
                    arr[x][y] = 2;
                    qu.add(new Elem(x, y));
                    flag = true;
                }
            }
        }

        if (flag) {
            flag = false;
            MAX_UNIT++;
            getMinUtil(qu, n, m, arr);
        }
        return MAX_UNIT;

    }

    boolean checkAllRot(int[][]arr, int n , int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                   return false;
                }
            }
        }
        return true;
    }

    int findMinTime(int[][] arr, int n, int m) {
        Queue<Elem> qu = new LinkedList<Elem>();
        MAX_UNIT = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    qu.add(new Elem(i, j));
                }
            }
        }
        int res = getMinUtil(qu, n, m, arr);
        return (checkAllRot(arr , n , m) ? res : -1);


    }

    public static void main(String[] args)  throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();

                }
            }
            MinimumTimeRequiredToRotAllOranges obj = new MinimumTimeRequiredToRotAllOranges();
            System.out.println(obj.findMinTime(arr, n, m));

        }

    }
}
