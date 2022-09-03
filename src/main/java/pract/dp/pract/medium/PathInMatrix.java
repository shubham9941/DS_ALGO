package pract.dp.pract.medium;

public class PathInMatrix {

    static int get(int[][] arr, int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        int firstMove = get(arr, i + 1, j - 1, n);
        int secondMove = get(arr, i + 1, j, n);
        int thirdMove = get(arr, i + 1, j + 1, n);

        int largestBetweenFirstTwo = (firstMove > secondMove) ? firstMove : secondMove;
        return (largestBetweenFirstTwo > thirdMove ? largestBetweenFirstTwo : thirdMove) + arr[i][j];
    }

    static int getMax(int[][] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            int res = get(arr, 0, j, n);
            if (res > max) {
                max = res;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {{348, 391}, {618 ,193}};
        System.out.println(getMax(arr ,arr.length));
    }
}
