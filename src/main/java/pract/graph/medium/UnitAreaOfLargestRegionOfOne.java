package pract.graph.medium;

import pract.Reader;
import pract.array.basic.FindMissingAndRepeating;


//Note :- this question is same as Find the number of islands

public class UnitAreaOfLargestRegionOfOne {

    int current_count = 0;
    int max = Integer.MIN_VALUE;

    int[] X = {0, 0, -1, 1, -1, 1, -1, 1};
    int[] Y = {-1, 1, 0, 0, -1, 1, 1, -1};

    boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1);
    }

    void DFS(int[][] arr, boolean[][] visited, int i, int j, int n, int m) {
        current_count++;
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (isValid(x, y, n, m) && arr[x][y] == 1 && !visited[x][y]) {
                DFS(arr, visited, x, y, n, m);
            }
        }
    }

    void largestRegion(int[][] arr, int n, int m) {
        current_count = 0;
        max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    DFS(arr, visited, i, j, n, m);
                    if (current_count > max) {
                        max = current_count;
                    }
                    current_count = 0;
                }
            }
        }
        System.out.println(max);
    }


    public static void main(String[] args) throws Exception {
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
            UnitAreaOfLargestRegionOfOne obj = new UnitAreaOfLargestRegionOfOne();
            obj.largestRegion(arr, n, m);

        }

    }
}
