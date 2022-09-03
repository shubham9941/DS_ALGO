package pract.array.easy;

import pract.Reader;

public class FindingNumberInBitonicArray {

    static int bSearchOnIncreasingNumber(int[] arr, int i, int j, int k) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[mid] > k) {
            return bSearchOnIncreasingNumber(arr, i, mid - 1, k);
        }
        return bSearchOnIncreasingNumber(arr, mid + 1, j, k);
    }

    static int bSearchOnDcreasingNumber(int[] arr, int i, int j, int k) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[mid] > k) {
            return bSearchOnDcreasingNumber(arr, mid + 1, j, k);
        }
        return bSearchOnDcreasingNumber(arr, i, mid - 1, k);
    }

    static int getPeakElement(int[] arr, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return getPeakElement(arr, mid + 1, j);
        }
        return getPeakElement(arr, i, mid - 1);
    }

    static int findElement(int[] arr, int n, int k) {
        int peakElement = getPeakElement(arr, 1, n - 2);
        if (peakElement == -1) {
            peakElement = (arr[n - 2] < arr[n - 1] ? n - 1 : -1);
        }
        System.out.println("ele = " + peakElement);

        if (arr[peakElement] == k) {
            return peakElement;
        }
        int leftSearch = bSearchOnIncreasingNumber(arr, 0, peakElement - 1, k);
        if (leftSearch != -1) {
            return leftSearch;
        }
        return bSearchOnDcreasingNumber(arr, peakElement + 1, n - 1, k);
    }

    public static void main(String[] args) throws Exception {
//        Reader sc = new Reader();
//        int testCases = sc.nextInt();
//        while (testCases-- > 0) {
//            int size = sc.nextInt();
//            int[] arr = new int[size];
//            for (int i = 0; i < size; i++) {
//                arr[i] = sc.nextInt();
//            }
//            int k = sc.nextInt();
//            System.out.println(findElement(arr,  size , k));
//        }

//        int arr[] = {1, 2, 3, 4, 5};
//        int k = 8;
//        System.out.println(findElement(arr, arr.length, k));
        String x = "Ab?/Ba";
        System.out.println("---x--- " + x.toLowerCase());
    }
}
