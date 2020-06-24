package pract.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOFNearestCellHavingOne {

    int n;
    int m;
    int[][] result;
    boolean[][] visted;
    int[] X = {0, 0, -1, 1};
    int[] Y = {-1, 1, 0, 0};

    DistanceOFNearestCellHavingOne(int n, int m) {
        this.n = n;
        this.m = m;
        result = new int[n][m];
        visted = new boolean[n][m];

    }

    static class QueueNode {
        int i;
        int j;
        int dist;

        QueueNode(int i, int j, int dist) {
            this.dist = dist;
            this.i = i;
            this.j = j;
        }
    }

    private boolean isValid(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < m) {
            return true;
        }
        return false;
    }

    void findDistnaceBFS(Queue<QueueNode> qu) {
        while (!qu.isEmpty()) {
            QueueNode ele = qu.poll();
            for (int i = 0; i < 4; i++) {
                int x = ele.i + X[i];
                int y = ele.j + Y[i];
                if (isValid(x, y) && !visted[x][y]) {
                    visted[x][y] = true;
                    result[x][y] = ele.dist + 1;
                    qu.add(new QueueNode(x , y , ele.dist + 1));
                }
            }


        }
    }


    int[][] findDistance(int[][] arr) {
        Queue<QueueNode> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    qu.add(new QueueNode(i, j, 0));
                    visted[i][j] = true;
                    result[i][j] = 0;

                }
            }
        }
        findDistnaceBFS(qu);
        return result;

    }

    public static void main(String[] args) {
        int mat[][] = { {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0} };
        int n  = 3 ;
        int m  = 4 ;

        DistanceOFNearestCellHavingOne obj = new DistanceOFNearestCellHavingOne(n , m);
        int[][] res  = obj.findDistance(mat);
        for(int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < m;  j ++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}
