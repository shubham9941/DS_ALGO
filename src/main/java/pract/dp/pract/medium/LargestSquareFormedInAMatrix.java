package pract.dp.pract.medium;



public class LargestSquareFormedInAMatrix
{
    static void printMaxSubSquare(int M[][])
    {
        int i,j;
        int R = M.length;		 //no of rows in M[][]
        int C = M[0].length;	 //no of columns in M[][]
        int S[][] = new int[R][C];

        int max_of_s, max_i, max_j;

        for(i = 0; i < R; i++)
            S[i][0] = M[i][0];

        for(j = 0; j < C; j++)
            S[0][j] = M[0][j];

        for(i = 1; i < R; i++)
        {
            for(j = 1; j < C; j++)
            {
                if(M[i][j] == 1)
                    S[i][j] = Math.min(S[i][j-1],
                            Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                else
                    S[i][j] = 0;
            }
        }

        // now get max from this matrix


    }

    // Driver program
    public static void main(String[] args)
    {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        printMaxSubSquare(M);
    }

}
