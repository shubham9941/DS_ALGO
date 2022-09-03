package pract.dp.mcm;
/**
 Input: p[] = {40, 20, 30, 10, 30}
 Output: 26000
 There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 Let the input 4 matrices be A, B, C and D.  The minimum number of
 multiplications are obtained by putting parenthesis in following way
 (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

 Input: p[] = {10, 20, 30, 40, 30}
 Output: 30000
 There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 Let the input 4 matrices be A, B, C and D.  The minimum number of
 multiplications are obtained by putting parenthesis in following way
 ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

 Input: p[] = {10, 20, 30}
 Output: 6000
 There are only two matrices of dimensions 10x20 and 20x30. So there
 is only one way to multiply the matrices, cost of which is 10*20*30
 */

public class MatrixChainMultiplication {
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k=i; k<j; k++)
        {
            int count = MatrixChainOrder(p, i, k) +
                    MatrixChainOrder(p, k+1, j) +
                    p[i-1]*p[k]*p[j];

            if (count < min)
                min = count;
        }

        // Return minimum count
        return min;
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is "+
                MatrixChainOrder(arr, 1, n-1));

    }
}

