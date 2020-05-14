package pract.array.basic;

public class FindPeakElement {
    static int findPeak(int[] arr, int l, int r, int n) {
        System.out.println("l  = " + l);
        System.out.println("r  = " + r);
        int mid = (l + r) / 2;
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return arr[mid];
        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeak(arr, l, mid - 1, n);
        else return findPeak(arr, mid + 1, r, n);
    }

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
        int arr[] = {1, 3, 2, 4, 1, 0};

        System.out.println(findPeak(arr, 0, arr.length - 1, arr.length));


    }
}
