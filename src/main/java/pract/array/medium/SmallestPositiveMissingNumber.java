package pract.array.medium;

import java.util.Arrays;

public class SmallestPositiveMissingNumber {

    static int segregate(int[] arr, int n) {
        int i = -1;
        for (int j = 0; j < n; j++) {
            if (arr[j] <= 0) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i = i + 1;
        return i;
    }

    static int findMissing(int[] arr, int n) {
        int segIndex = segregate(arr, n);
        for (int i = segIndex; i < n; i++) {
            int x = Math.abs(arr[i]);

            if (x-1 < n && arr[x - 1 + segIndex] > 0) {
                arr[x - 1 + segIndex] = -arr[x - 1 + segIndex];
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = segIndex; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1-segIndex;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int res = findMissing(arr, arr.length);
        System.out.println("Res = " + res);

    }
}
