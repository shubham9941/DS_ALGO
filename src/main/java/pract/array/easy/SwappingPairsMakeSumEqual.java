package pract.array.easy;

import java.io.*;
        import java.util.*;

class SwappingPairsMakeSumEqual
{
    // Function to calculate sum of elements of array
    static int getSum(int X[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += X[i];
        return sum;
    }

    // Function to calculate : a - b = (sumA - sumB) / 2
    static int getTarget(int A[], int n, int B[], int m)
    {
        // Calculation of sums from both arrays
        int sum1 = getSum(A, n);
        int sum2 = getSum(B, m);

        // because that the target must be an integer
        if ((sum1 - sum2) % 2 != 0)
            return 0;
        return ((sum1 - sum2) / 2);
    }

    // Function to prints elements to be swapped
    static void findSwapValues(int A[], int n, int B[], int m)
    {
        // Call for sorting the arrays
        Arrays.sort(A);
        Arrays.sort(B);

        // Note that target can be negative
        int target = getTarget(A, n, B, m);

        System.out.println(">>>> target >>> " + target);

        // target 0 means, answer is not possible
        if (target == 0)
            return;

        int i = 0, j = 0;
        while (i < n && j < m)
        {
            int diff = A[i] - B[j];
            if (diff == target)
            {
                System.out.println(A[i]+" "+B[i]);
                return;
            }

            // Look for a greater value in A[]
            else if (diff < target)
                i++;

                // Look for a greater value in B[]
            else
                j++;
        }
    }

    // driver program
    public static void main (String[] args)
    {

        int A[] = {5, 7, 4, 6}, B[] = {1, 2, 3, 8} ;

        int n = A.length;
        int m = B.length;

        // Call to function
        findSwapValues(A, n, B, m);
    }
}

