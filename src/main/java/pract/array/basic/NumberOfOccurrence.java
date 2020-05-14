package pract.array.basic;

// this example is about to find number of occurrence of an element in shorted array
/*
 * [1 1 2 2 2 2 3] => 2 occurs 4 times in 1 1 2 2 2 2 3
 * */

public class NumberOfOccurrence {
    static int binarySearch(int[] arr, int l, int r, int n) {
        if (r >= l) {
            int m = (l + r) / 2;
            if (arr[m] == n) {
                return m;
            } else if (n < arr[m]) {
                return binarySearch(arr, l, m - 1, n);
            } else {
                return binarySearch(arr, m + 1, r, n);
            }
        } else {
            return -1;
        }

    }

    static int countInLeft(int[] arr, int start, int n) {
        int count = 0;
        for (int i = start; i >= 0; i--) {
            if (arr[i] == n) count++;
            else break;
        }
        return count;
    }

    static int countInRight(int[] arr, int start, int n) {
        int count = 0;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == n) count++;
            else break;
        }
        return count;
    }

    static int getNumberOfOcc(int[] arr, int n) {
        int index = binarySearch(arr, 0, arr.length - 1, n);
        if (index == -1) return index;
        else {
            return countInLeft(arr, index - 1, n) + countInRight(arr, index + 1, n) + 1;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(getNumberOfOcc(arr, 2));


    }
}
