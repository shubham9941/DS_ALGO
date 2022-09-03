package pract.dp.lcs.palindrom;

public class MinimumNumberOfDeletionToConvertInPalindrome {

    // just find LPS(LongestPalindromeSubSequence) and find diff in provided string
    // Note same code is for insertion also no diff
    static int find(String str) {
        String lps = LongestPalindromeSubSequence.LPS(str);
        return (str.length() - lps.length());
    }

    public static void main(String[] args) {
        System.out.println(find("ANITINB"));
    }
}
