package pract.array.hard;

import java.util.Arrays;

/**
 * Input: arr1[] = {10};
 * arr2[] = {2, 3};
 * Output: arr1[] = {2}
 * arr2[] = {3, 10}
 * <p>
 * Input: arr1[] = {1, 5, 9, 10, 15, 20};
 * arr2[] = {2, 3, 8, 13};
 * Output: arr1[] = {1, 2, 3, 5, 8, 9}
 * arr2[] = {10, 13, 15, 20}
 */

public class MergeWithoutExtraSpace {

    static void sort(int[] arr1, int[] arr2, int n, int m) {
        if (n != 0 && m != 0) {

            int larger = arr1[n - 1];

            if (!(arr2[m - 1] < larger)) {
                sort(arr1, arr2, n, m - 1);
            } else {
                int i = n - 2;
                int j = m - 1;
                while (i >= 0 && arr2[j] < arr1[i]) {
                    arr1[i + 1] = arr1[i];
                    i--;
                }
                arr1[i + 1] = arr2[j];
                arr2[j] = larger;


                sort(arr1, arr2, n, m - 1);
            }
        }
    }

    public static void main(String[] args) {

        int arr1[] = {1,2,3};
        int arr2[] = {4,5};
        sort(arr1, arr2, arr1.length, arr2.length);

        System.out.println(">>>>>>>>>");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));


    }
}
