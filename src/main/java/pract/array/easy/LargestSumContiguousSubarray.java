package pract.array.easy;

public class LargestSumContiguousSubarray {

    static int getMax(int[] arr, int n) {
        int max_soFar = arr[0];
        int current_max = arr[0];
        for (int i = 1; i < n; i++) {
            current_max = Integer.max(current_max + arr[i], arr[i]);
            max_soFar = (current_max > max_soFar) ? current_max : max_soFar;
        }
        return max_soFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(getMax(arr , arr.length));
    }
}
