package pract.dp.lcs.palindrom;

//LongestPalindromeSubSequence(LPS)

// it is same as LCS but in LCS you required the 2 string and here is one string provided.
// Idea is reverse the given string to make it second.

// Note:- this is not a subString its a subSequence so palindrome can be taken by leave middle elements

import pract.dp.lcs.PrintLCS;

public class LongestPalindromeSubSequence {

    static String LPS(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        return PrintLCS.getLCS(str.toCharArray(), reverseStr.toCharArray(), str.length(), str.length());
    }

    public static void main(String[] args) {
        System.out.print(LPS("GEEKSFORGEEKS"));
        //There can be many palindrome but max will be length 5
        // like EEKEE , EESEE, EEFEE ...
    }
}
