package pract.array.easy;

/**
 * Given a binary array A of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.
 * <p>
 * Input:
 * The first line contains an integer T denoting the total number of test cases. In each test cases, the first line contains an integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.  Third line consists of an integer m that is maximum number of flips allowed.
 * <p>
 * Output:
 * Output the maximum numbers of consecutive 1's.
 */

public class MaximizeNumberOf_1_s {

    static int getMax(int[] arr, int n, int k, int res) {
        if (n == 0) {
            return res;
        }
        if (arr[n - 1] == 1) {
            return getMax(arr, n - 1, k, res + 1);
        }

        if (k == 0) {
            return res;
        }
        int a = getMax(arr, n - 1, k - 1, res + 1);
        int b = getMax(arr, n - 1, k, 0);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return Integer.max(a, b);
    }



    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(getMax(arr, arr.length, 2, 0));

    }
}
