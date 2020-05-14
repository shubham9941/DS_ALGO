package pract.array.basic;

public class RotateArray {
    void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = arr[pos1];
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    void leftRotate(int arr[], int d, int n)
    {
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        System.out.println(">>>g_c_d>>>>" + g_c_d);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            System.out.println(">>d>>>" + d);
            while (true) {
                k = j + d;
                if (k >= n){
                    System.out.println("Last value of k = " + k);
                    System.out.println("After deduction its value: " + (k-n));
                    System.out.println("Array start ");
                    for(int p : arr){
                        System.out.print(p + " ");
                    }
                    k = k - n;
                    System.out.println("Array stop ");
                }
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            System.out.println(">>>j>>>" + j);
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        RotateArray ra = new RotateArray();
        int [] arr = {1,2,3,4,5,6,7};
        ra.leftRotate(arr , 2, 7);
        for(int i : arr){
            System.out.println(i);
        }

    }
}
