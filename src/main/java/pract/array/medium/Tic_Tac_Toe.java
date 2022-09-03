package pract.array.medium;

/**
 A Tic-Tac-Toe board is given after some moves are played. Find out if the given board is valid, i.e., is it possible to reach this board position after some moves or not.

 Note that every arbitrary filled grid of 9 spaces isn’t valid e.g. a grid filled with 3 X and 6 O isn’t valid situation because each player needs to take alternate turns.

 Note :  The game starts with X
 */

public class Tic_Tac_Toe {

    // This matrix is used to find indexes to check all
// possible wining triplets in board[0..8]
    static int win[][] = {{0, 1, 2}, // Check first row.
            {3, 4, 5}, // Check second Row
            {6, 7, 8}, // Check third Row
            {0, 3, 6}, // Check first column
            {1, 4, 7}, // Check second Column
            {2, 5, 8}, // Check third Column
            {0, 4, 8}, // Check first Diagonal
            {2, 4, 6}}; // Check second Diagonal

    // Returns true if character 'c' wins. c can be either
// 'X' or 'O'
    static boolean isCWin(char[] board, char c) {
        // Check all possible winning combinations
        for (int i = 0; i < 8; i++) {
            if (board[win[i][0]] == c
                    && board[win[i][1]] == c
                    && board[win[i][2]] == c) {
                return true;
            }
        }
        return false;
    }

    // Returns true if given board is valid, else returns false
    static boolean isValid(char board[]) {
        // Count number of 'X' and 'O' in the given board
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == 'X') {
                xCount++;
            }
            if (board[i] == 'O') {
                oCount++;
            }
        }

        // Board can be valid only if either xCount and oCount
        // is same or xount is one more than oCount
        if (xCount == oCount || xCount == oCount + 1) {
            // Check if 'O' is winner
            if (isCWin(board, 'O')) {
                // Check if 'X' is also winner, then
                // return false
                if (isCWin(board, 'X')) {
                    return false;
                }

                // Else return true xCount and yCount are same
                return (xCount == oCount);
            }

            // If 'X' wins, then count of X must be greater
            if (isCWin(board, 'X') && xCount != oCount + 1) {
                return false;
            }

            // If 'O' is not winner, then return true
            return true;
        }
        return false;
    }

    // Driver program
    public static void main(String[] args) {
        char board[] = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X'};

        if ((isValid(board))) {
            System.out.println("Given board is valid");
        } else {
            System.out.println("Given board is not valid");
        }
    }
}
