package pract.array.easy;

import java.util.Arrays;

public class SubArrayDivisibleByK {

    static void countUsingBrutForce(int[] arr, int l, int k) {
        int res = 0;
        for (int i = 0; i < l; i++) {
            int sum = arr[i];
            if (arr[i] == k || arr[i] == 0) {
                System.out.println("NUmber found --> " + arr[i]);
                res++;
            }
            for (int j = i + 1; j < l; j++) {

                sum += arr[j];

                if (sum % k == 0){
                    System.out.println("i = " + i + " j = " + j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    //An efficient solution O(n+m)

    static int subCount(int arr[], int n, int k)
    {

        // create auxiliary hash array to
        // count frequency of remainders
        int mod[] = new int[k];
        Arrays.fill(mod, 0);

        // Traverse original array and compute cumulative
        // sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder
        // in mod[] array
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];

            // as the sum can be negative, taking modulo twice
            mod[((cumSum % k) + k) % k]++;
        }

        // Initialize result
        int result = 0;

        // Traverse mod[]
        for (int i = 0; i < k; i++)

            // If there are more than one prefix subarrays
            // with a particular mod value.
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;

        // add the elements which are divisible by k itself
        // i.e., the elements whose sum = 0
        result += mod[0];

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        countUsingBrutForce(arr, arr.length, 5);
//        System.out.print(subCount(arr, arr.length, 5));

    }
}
