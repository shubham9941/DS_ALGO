package pract.array.easy;

/*
Input: arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30
Explanation: As 5 < 6 < 30, and they
appear in the same sequence in the array

Input: arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4
Explanation: As the array is sorted, for every i, j, k,
where i < j < k, arr[i] < arr[j] < arr[k]

Input: arr[] = {4, 3, 2, 1}
Output: No such triplet exists.

*/

public class SortedSubSequence {

    static void find3Numbers(int arr[]) {
        int n = arr.length;

        // Index of maximum element
        // from right side
        int max = n - 1;

        // Index of minimum element
        // from left side
        int min = 0;
        int i;

        // Create an array that will store
        // index of a smaller element on left side.
        // If there is no smaller element on left
        // side, then smaller[i] will be -1.
        int[] smaller = new int[n];

        // first entry will always be -1
        smaller[0] = -1;
        for (i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smaller[i] = -1;
            } else
                smaller[i] = min;
        }

        // Create another array that will
        // store index of a greater element
        // on right side. If there is no greater
        // element on right side, then greater[i]
        // will be -1.
        int[] greater = new int[n];

        // last entry will always be -1
        greater[n - 1] = -1;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                greater[i] = -1;
            } else
                greater[i] = max;
        }

        // Now find a number which has
        // both greater number on right
        // side and smaller number on left side


        for (int sm : smaller) {
            System.out.println("sm -> " + sm);
        }

        System.out.println();

        for (int lg : greater) {
            System.out.println("lg -> " + lg);
        }


        for (i = 0; i < n; i++) {

            if (smaller[i] != -1 && greater[i] != -1) {
                System.out.println("i = " + i);
                System.out.println("==smaller[i]== " + smaller[i]);
                System.out.println("==greater[i]== " + greater[i]);
                System.out.println("==a[i]== " + arr[i]);

                System.out.print(
                        arr[smaller[i]] + " " + arr[i]
                                + " " + arr[greater[i]]);
                return;
            }
        }

        // If we reach number, then there
        // are no such 3 numbers
        System.out.println("No such triplet found");
        return;
    }





    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
//        int[] arr = {12, 11, 10, 5, 6, 2, 30};
        find3Numbers(arr);
//        find3Num(arr , arr.length);
    }
}
