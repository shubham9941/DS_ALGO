package pract.dp.pract.medium;

// Count of n digit numbers whose sum of digits equals to given sum

public class CountOf_N_DigitNumbers {

    static int get(int[] arr, int n, int sum, int l) {
        System.out.println("n = " + n + " sum = " +  sum + " l = " + l);
        if (sum == 0 && l == 0) {
            return 1;
        }
        if (l == 0 || n == 0) {
            return 0;
        }

        if (arr[n - 1] > sum) {
            return get(arr, n - 1, sum, l);
        }

        return get(arr, n, sum - arr[n - 1], l - 1) + get(arr, n - 1, sum, l);
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5};
        System.out.println(get(arr, arr.length, 5, 2));


    }
}
