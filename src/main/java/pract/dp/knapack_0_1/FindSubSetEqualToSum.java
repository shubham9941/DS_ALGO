package pract.dp.knapack_0_1;

/**
 * Is there any subset exist whose sum equal to provided sum like
 * Example: - [2,3,7,8,10] and find sum = 11
 * so subset will be [3,8]
 * <p>
 * Note: - subset could be sequence and could not be sequence
 */

public class FindSubSetEqualToSum {

    //using recursion
    static boolean isSubSetExist(int[] arr, int sum, int n) {
        System.out.println("sum = " + sum);

        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (arr[n - 1] <= sum) {
            return isSubSetExist(arr, sum - arr[n - 1], n - 1) || isSubSetExist(arr, sum, n - 1);
        } else {
            return isSubSetExist(arr, sum, n - 1);
        }
    }

    //using Matrix
    static boolean isSubSetExistUsingMatrix(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] =  t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 7, 8, 10};
        System.out.println(isSubSetExistUsingMatrix(arr, 9, arr.length));


    }
}
