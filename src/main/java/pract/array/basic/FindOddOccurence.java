package pract.array.basic;

public class FindOddOccurence {

    static int getOddOccurrence(int ar[], int ar_size)
    {
        int i;
        int res = 0;
        for (i = 0; i < ar_size; i++)
        {
            res = res ^ ar[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int ar[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = ar.length;
        System.out.println(getOddOccurrence(ar, n));
    }
}
