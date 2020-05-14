package pract.array.easy;

import pract.Reader;

public class AmountOfWater {

    static int calculate(int[] arr, int min, int size, int totalUnit) {
        int temp = 0;
        for (int i = min + 1; i < size; i++) {
            if (arr[i] >= arr[min]) {
                totalUnit += temp;
                temp = 0;
                min = i;
            } else {
                temp += arr[min] - arr[i];
            }
        }
        int k = min;
        min = size - 1;

        for (int j = size - 2; j > k; j--) {
            if (arr[j] >= arr[min]) {
                min = j;
            } else {
                totalUnit += arr[min] - arr[j];
            }
        }

        return totalUnit;
    }

    //My solution
    static int printUnit(int[] arr, int size) {
        int i = 0;
        while (i < size - 1 && arr[i] <= arr[i + 1])
            i++;
        return calculate(arr, i, size, 0);
    }

    //GEEKS solution
    static int findWater(int[] arr, int n) {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .

        for (int l : left) {
            System.out.print(l + " ");
        }
        System.out.println();
        for (int r : right) {
            System.out.print(r + " ");
        }
        System.out.println();


        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(findWater(arr, size));
        }
    }
}
