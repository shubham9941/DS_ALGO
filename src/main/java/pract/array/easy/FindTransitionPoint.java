package pract.array.easy;

public class FindTransitionPoint {

    static int find(int[] arr, int i, int j) {
        if (i > j) {
            return -1;
        }


        int m = (i + j) / 2;
        if (arr[m] == 1 && arr[m - 1] == 0) {
            return m;
        } else if (arr[m] == 0) {
            return find(arr, m + 1, j);
        } else {
            return find(arr, i, m - 1);
        }

    }

    static int transitionPoint(int arr[], int n) {
        int res = find(arr , 1 , n-1);
        if(res == -1 && arr[0] == 1){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {

//        int[]arr = {0, 0, 0, 1, 1};
//        int[]arr = {0, 0, 0, 0, 0};
        int[]arr = {1,1, 1, 1, 1, 1};

//        System.out.println(find(arr , 1 , arr.length-1));
        System.out.println(transitionPoint(arr, arr.length));


    }
}
