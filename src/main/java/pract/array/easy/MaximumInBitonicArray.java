package pract.array.easy;

import pract.Reader;

public class MaximumInBitonicArray {

    static int getMax(int[] arr, int l, int r, int size) {
        if (l <= r) {
            int mid = (l + r) / 2;
            System.out.println("mid " + mid);
            System.out.println("size " + size);
            if (mid != 0 && mid != size - 1 && arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return arr[mid];
            } else if (mid != 0 && arr[mid - 1] > arr[mid]) {
                return getMax(arr, l, mid - 1, size);
            } else if (mid != size - 1 && arr[mid + 1] > arr[mid]) {
                return getMax(arr, mid + 1, r, size);
            } else if (mid == size - 1 && mid != 0 && arr[mid - 1] < arr[mid]) {
                return arr[mid];
            } else return -1;
        } else return -1;
    }

    static int easyWayUtil(int[]arr , int i , int j){
        if(i > j){
            return -1;
        }
        int mid = (i + j) / 2;
        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
            return arr[mid];
        }
        else if(arr[mid] < arr[mid+1]){
            return easyWayUtil(arr , mid+1 , j);
        }
        else if (arr[mid] > arr[mid+1]){
            return easyWayUtil(arr , i , mid-1);
        }
        return -1;
    }

    static int easyWay(int[]arr, int i , int j){
        int res = easyWayUtil(arr , i+1 , j-1);
        if(res == -1 && arr[j] > arr[j-1]){
            return arr[j];
        }
        return res;
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
//            System.out.println(getMax(arr, 0, size - 1, size));
            System.out.println(easyWay(arr, 0, size - 1));
        }
    }
}
