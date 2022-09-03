package pract.dp.pract.easy;

/**
 Count of strings that can be formed using a, b and c under given constraints
 Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.

 Examples :

 Input : n = 3
 Output : 19
 Below strings follow given constraints:
 aaa aab aac aba abc aca acb acc baa
 bac bca bcc caa cab cac cba cbc cca ccb

 Input  : n = 4
 Output : 39
 */

public class CountNumberOfStrings {

    // Its calculating same subpprob again and again, can use DP matrix for that
    static int count(int n , int bCount , int cCount){
        if(bCount < 0 || cCount < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }

        return
                count(n-1 , bCount , cCount) +
                        count(n-1 , bCount-1,cCount) +
                        count(n-1 , bCount,cCount-1);
    }

    public static void main(String[] args) {

        int n = 3 ;
        System.out.println(count(n , 1 , 2));

    }
}
