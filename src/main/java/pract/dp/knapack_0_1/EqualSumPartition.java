package pract.dp.knapack_0_1;

/**
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 * <p>
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 */

public class EqualSumPartition {

    boolean canWeDevide(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {   // we can not findout the partition point of odd number
            return false;
        }
        else{
            FindSubSetEqualToSum obj = new FindSubSetEqualToSum();
            return obj.isSubSetExistUsingMatrix(arr , sum / 2 , n);

        }
    }

    public static void main(String[] args) {

    }
}
