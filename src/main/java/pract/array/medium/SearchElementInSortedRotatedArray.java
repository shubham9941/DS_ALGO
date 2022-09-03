package pract.array.medium;

public class SearchElementInSortedRotatedArray {

    static int search(int[] arr, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[l] <= arr[mid]) {
            if (k >= arr[l] && k < arr[mid]) {
                return search(arr, l, mid - 1, k);
            }
            return search(arr, mid + 1, r, k);
        }

        if (k > arr[mid] && k <= arr[r]) {
            return search(arr, mid + 1, r, k);
        }
        return search(arr, l, mid - 1, k);
    }

    public static void main(String[] args) {

        int[]arr = {30, 40, 50, 10, 20};
        System.out.println(search(arr , 0 , arr.length-1 , 10));

    }
}
