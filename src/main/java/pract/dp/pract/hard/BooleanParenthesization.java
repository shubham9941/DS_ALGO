package pract.dp.pract.hard;

public class BooleanParenthesization {

    static int solve(char[] arr, int i, int j, char lf, int[][][] t) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return (arr[i] == lf) ? 1 : 0;
        }


        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("lf = " + lf);
        if (t[i][j][lf] != -1) {
            return t[i][j][lf];
        }
        System.out.println();

        int res = 0;


        for (int k = i + 1; k <= j - 1; k = k + 2) {

            int left_true = solve(arr, i, k - 1, 'T', t);
            int left_false = solve(arr, i, k - 1, 'F', t);

            int right_true = solve(arr, k + 1, j, 'T', t);
            int right_false = solve(arr, k + 1, j, 'F', t);


            if (arr[k] == '&') {
                if (lf == 'T') {
                    res += (left_true * right_true);
                } else {
                    res += ((left_true * right_false) + (left_false * right_true) + (left_false * right_false));
                }
            }
            if (arr[k] == '|') {
                if (lf == 'T') {
                    res += ((left_true * right_false) + (left_false * right_true) + (left_true * right_true));
                } else {
                    res += (left_false * right_false);
                }
            }
            if (arr[k] == '^') {
                if (lf == 'T') {
                    res += ((left_true * right_false) + (left_false * right_true));
                } else {
                    res += ((left_true * right_true) + (right_false * left_false));
                }
            }
        }
        return t[i][j][lf] = res;
    }

    public static void main(String[] args) {

        String exp = "T|T&F^T";

        int[][][] t = new int[exp.length() + 1][exp.length() + 1][2];
        for (int i = 0; i < exp.length() + 1; i++) {
            for (int j = 0; j < exp.length() + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    t[i][j][k] = -1;
                }
            }
        }

        int res = solve(exp.toCharArray(), 0, exp.length() - 1, 'T', t);

        System.out.println(">>Res>> " + res);

    }
}
