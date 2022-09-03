package pract.dp.pract.medium;

public class UniqueBST {
    static int numberOfBST(int n)
    {

        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {

                dp[i] = dp[i] + (dp[i - j] *
                        dp[j - 1]);
            }
        }

        return dp[n];
    }

    public static void main (String[] args)
    {
        int n = 3;
        System.out.println("Number of structurally " +
                "Unique BST with "+ n +
                " keys are : " +
                numberOfBST(n));
    }
}
