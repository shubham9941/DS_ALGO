package pract.interview_questions;

public class SearchElementInSortedRotatedArray {
   static int find(int[] arr, int l, int r, int k) {
       System.out.println("l = " + l + " r = " + r);
        if (l > r) {
            return -1;
        }
        int m = (l + r) / 2;
        if (arr[m] == k) {
            return m;
        }
        if (arr[l] <= arr[m]) {
            if (k >= arr[l] && k <= arr[m]) {
                return find(arr, l, m - 1, k);
            }
            return find(arr, m + 1, r, k);
        } else {
            if (k >= arr[m] && k <= arr[r]) {
                return find(arr, m + 1, r, k);
            }
            return find(arr, l, m - 1, k);
        }
    }

    public static void main(String[] args) {

        int[]arr = {30, 40, 50, 10, 20};
        System.out.println(find(arr, 0 , arr.length-1,  10));



    }
}
