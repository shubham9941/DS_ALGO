package pract.dp.mcm;

public class PalindromePartitioning {

    static boolean isPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Note this is using Recursion do it using memoized version
    static int getMinPartation(char[] arr, int i, int j) {
        if (i <= j) {
            if (i == j || isPalindrome(arr, i, j)) {
                return 0;
            }
            int minRes = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                int res = 1 + getMinPartation(arr, i, k) + getMinPartation(arr, k + 1, j);
                if (res < minRes) {
                    minRes = res;
                }
            }
            return minRes;
        }
        return 0;
    }

    public static void main(String[] args) {

        char[] arr = "ababbbabbababa".toCharArray();
        System.out.print(getMinPartation(arr , 0 , arr.length-1));

    }
}
