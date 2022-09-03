package pract.graph.medium;

//Distance of nearest cell having 1 in a binary matrix

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {

    static int X[] = {0, 0, - 1, 1};
    static int Y[] = {-1, 1, 0, 0};

    static class Node {
        int i;
        int j;
        int dis;

        Node(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }

    static boolean isSafe(int i, int j, int n, int m) {
        if (i >= n || i < 0 || j >= m || j < 0) {
            return false;
        }
        return true;
    }

    static int[][] findDistance(int[][] mat, int n, int m) {

        // make all visited with 1 and insert into queue;
        boolean[][] visted = new boolean[n][m];
        int[][] res = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node top = q.poll();

                for (int i = 0; i < 4; i++) {
                    System.out.println(">>>!>>>>" + i);
                    int x_pos = top.i + X[i];
                    int y_pos = top.j + Y[i];

                    System.out.println("x = " + x_pos);
                    System.out.println("x = " + y_pos);
                    System.out.println();

                    if (isSafe(x_pos, y_pos, n, m) && mat[x_pos][y_pos] != 1 && !visted[x_pos][y_pos]) {
                        visted[x_pos][y_pos] = true;
                        mat[x_pos][y_pos] = 1;
                        res[x_pos][y_pos] = top.dis + 1;
                        q.add(new Node(x_pos, y_pos, res[x_pos][y_pos]));
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {



        int mat[][] = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };

        int[][] res = findDistance(mat, 3, 4);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
