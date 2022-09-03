package pract.dp.pract.medium;

public class CountNumberOfWaysToFill {

    //This is recursion, use matrix for dp
    static int get(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        return get(n - 1) + get(n-4);
    }

    public static void main(String[] args) {
        System.out.println(get(8));
    }
}
