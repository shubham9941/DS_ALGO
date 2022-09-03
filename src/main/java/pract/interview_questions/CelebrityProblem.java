package pract.interview_questions;

public class CelebrityProblem {

    static int findCelibrity(int[][] arr, int start, int end) {
        if (start == end) {
            return start;
        }
        int j = findCelibrity(arr, start + 1, end);
        return (arr[start][j] == 1) ? j : start;
    }

    static boolean validateCelebrity(int[][] arr, int cel, int end) {
        for (int j = 0; j < end; j++)
            if (arr[cel][j] == 1) return false;

        for (int i = 0; i < end; i++) {
            if (i != cel){
                if(arr[i][cel]!=1) return false;
            }
        }

        return true;
    }

    static int getId(int[][] arr, int n) {
        int id = findCelibrity(arr, 0, n - 1);
        System.out.println("id = " + id);
        return (validateCelebrity(arr, id, n) ? id : -1);
    }

    public static void main(String[] args) {

        int N = 3;
        int M[][] = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0},
        };

        System.out.println(getId(M, N));

    }
}
