package pract.dp.lcs;

/**
 * Minimum number of deletions and insertions to transform one string into another
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
 * <p>
 * Examples:
 * <p>
 * Input : str1 = "heap", str2 = "pea"
 * Output : Minimum Deletion = 2 and
 * Minimum Insertion = 1
 * p and h deleted from heap
 * Then, p is inserted at the beginning
 * One thing to note, though p was required yet
 * it was removed/deleted first from its position andfind
 * then it is inserted to some other position.
 * Thus, p contributes one to the deletion_count
 * and one to the insertion_count.
 * <p>
 * Input : str1 = "geeksforgeeks", str2 = "geeks"
 * Output : Minimum Deletion = 8
 * Minimum Insertion = 0
 */

public class MinDeletionsAndInsertionsRequired {

    static void find(String s1 , String s2){
       String lcs =  PrintLCS.getLCS(s1.toCharArray() , s2.toCharArray() , s1.length(), s2.length());
       System.out.println("Deletion:= " + (s1.length() - lcs.length()));
       System.out.println("Insertion:= " + (s2.length() - lcs.length()));
    }

    public static void main(String[] args) {
        // Just find out LCS and see magic
        find("sunday" ,  "saturday");

    }
}
