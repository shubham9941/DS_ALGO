package pract.dp.pract.medium;

public class WildcardPatternMatching {


    static boolean wildCard(char[] str, char[] pattern, int n1, int n2) {

        if (n1 == 0 && n2 == 0) {
            return true;
        }


        if (n1 <= 0) {
            if (pattern[n2 - 1] == '*') {
                return wildCard(str, pattern, n1, n2 - 1);
            }
            return false;
        }

        if (n2 <= 0) {
            return false;
        }


        if (pattern[n2 - 1] == '*') {
            return
                    wildCard(str, pattern, n1 - 1, n2 - 1) ||
                            wildCard(str, pattern, n1, n2 - 1) ||
                            wildCard(str, pattern, n1 - 1, n2);
        }


        if ((str[n1 - 1] == pattern[n2 - 1]) || pattern[n2 - 1] == '?') {
            return wildCard(str, pattern, n1 - 1, n2 - 1);
        }
        return false;
    }

    static boolean wildCardUsingDP(char[] str, char[] pattern, int n1, int n2) {
        boolean[][] t = new boolean[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true;
                } else if (j == 0) {
                    t[i][j] = false;
                } else if (i == 0) {
                    if (pattern[j - 1] == '*') {
                        t[i][j] = t[i][j - 1];
                    } else {
                        t[i][j] = false;
                    }
                } else if (pattern[j - 1] == '*') {
                    t[i][j] = t[i - 1][j - 1] || t[i][j - 1] || t[i - 1][j];
                } else if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '?') {
                    t[i][j] = t[i - 1][j - 1];
                } else {
                    t[i][j] = false;
                }
            }
        }
        return t[n1][n2];
    }

    public static void main(String[] args) {

        char[] str = "baaabab".toCharArray();

//        char[] pattern = "*****ba*****ab".toCharArray();
//        char[] pattern = "baaa?ab".toCharArray();
//        char[] pattern = "ba*a?".toCharArray();
        char[] pattern = "a*ab".toCharArray();


//        char[] str = "aa".toCharArray();
//        char[] pattern = "a*a".toCharArray();


        System.out.println(wildCardUsingDP(str, pattern, str.length, pattern.length));


    }
}
