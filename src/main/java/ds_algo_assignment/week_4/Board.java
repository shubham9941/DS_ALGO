package ds_algo_assignment.week_4;

import java.util.ArrayList;

public class Board {

    int hammer;
    int priority;

    private int[][] tiles;
    private int n;
    private int[][] goalArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };


    private Board exchange(int i1, int j1, int i2, int j2) {
        int[][] newData = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newData[i][j] = this.tiles[i][j];
            }
        }
        int temp = newData[i1][j1];
        newData[i1][j1] = newData[i2][j2];
        newData[i2][j2] = temp;
        return new Board(newData);

    }

    public Board(int[][] tiles) {
        this.tiles = tiles;
        this.n = tiles.length;
        hammer = priority = hamming();
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n");

        for (int[] tile : tiles) {
            for (int j = 0; j < n; j++) {
                sb.append(tile[j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        Board goal = new Board(goalArray);
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != goal.tiles[i][j])
                    total++;
            }
        }
        return total;
    }

    // sum of Manhattan distances between tiles and goal
//    public int manhattan()

    // is this board the goal board?
    public boolean isGoal() {
        Board goal = new Board(goalArray);
        return equals(goal);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        Board b = (Board) y;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(this.tiles[i][j] == b.tiles[i][j]))
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> list = new ArrayList<Board>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] == 0) {
                    if (j != 0) {
                        list.add(exchange(i, j, i, j - 1));
                    }
                    if (j != n - 1) {
                        list.add(exchange(i, j, i, j + 1));
                    }
                    if (i != 0) {
                        list.add(exchange(i, j, i - 1, j));
                    }
                    if (i != n - 1) {
                        list.add(exchange(i, j, i + 1, j));
                    }
                }
            }
        }
        return list;
    }

    // a board that is obtained by exchanging any pair of tiles
//    public Board twin()

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        Board obj = new Board(arr);
        System.out.println(obj);
        System.out.println("Now priting the ne");
//        obj.exchange(0,0,0,1);
//        System.out.println(obj);
        obj.neighbors().forEach(System.out::println);

    }

}