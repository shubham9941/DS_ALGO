package pract.dp.pract.medium;

public class KadanesAlgorithm {
    static int maxSubArraySum(int arr[], int n) {
        int max_so_far = arr[0];
        int max_ending_here = arr[0];

        for (int i = 1; i < n; i++) {
            max_ending_here = Integer.max(arr[i], arr[i] + max_ending_here);
            max_so_far = Integer.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static void main(String[] args) {


//        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, n - 1);
        System.out.println("Maximum contiguous sum is "
                + max_sum);


    }
}
