package pract.array.medium;

import pract.Reader;

import java.util.Arrays;
import java.util.HashMap;

public class LongestArithmeticProgression {

    // Returns length of the longest
// AP subset in a given set
    static int Solution(int []A)
    {
        int ans = 2;
        int n = A.length;
        if (n <= 2)
            return n;

        int []llap = new int[n];
        for(int i = 0; i < n; i++)
            llap[i] = 2;

        Arrays.sort(A); // IF array is not sorted

        for (int j = n - 2; j >= 0; j--)
        {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k < n)
            {
                if (A[i] + A[k] == 2 * A[j])
                {
                    llap[j] = Math.max(llap[k] + 1, llap[j]);
                    ans = Math.max(ans, llap[j]);
                    i -= 1;
                    k += 1;
                }
                else if (A[i] + A[k] < 2 * A[j])
                    k += 1;
                else
                    i -= 1;
            }
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int []a = { 9, 4, 7, 2, 10 };
        System.out.print(Solution(a) +"\n");
    }
}
