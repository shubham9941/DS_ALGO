package pract.array.basic;

public class FindPeakElement {
    static int findPeak(int[] arr, int l, int r, int n) {
        System.out.println("l  = " + l);
        System.out.println("r  = " + r);
        int mid = (l + r) / 2;
        System.out.println("mid = " + mid);
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return arr[mid];
        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeak(arr, l, mid - 1, n);
        else return findPeak(arr, mid + 1, r, n);
    }


    static int peakElement(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        int mid = (i + j) / 2;
        if (mid == i) {
            return (arr[mid] > arr[mid + 1]) ? arr[mid] : peakElement(arr, mid + 1, j);
        }
        if (mid == j) {
            return (arr[mid] > arr[mid - 1]) ? arr[mid] : peakElement(arr, i, mid - 1);
        }

        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        }
        else if(arr[mid] > arr[mid-1]){
            return peakElement(arr , mid+1 , j);
        }
        else {
            return peakElement(arr , i , mid-1);
        }

    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 15, 2, 23, 90, 67};
//        int arr[] = {3,4};

//        System.out.println(findPeak(arr, 0, arr.length - 1, arr.length));
        System.out.println(peakElement(arr, 0   , arr.length - 1));


    }
}
