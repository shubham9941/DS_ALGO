package pract.graph.easy;

public class ShortestPathToReachOnePrime {

    static void printNumber(int n, int d_by, int actual_num) {
        if(d_by > 100){
            throw new RuntimeException("This-------");
        }
        System.out.println(n);
        System.out.print("d_by = " + d_by);
        int rest = n / d_by;
        if (rest > 0) {
            int next_num = n % 10 + 1;
            if (next_num == 10) {
                printNumber(actual_num, d_by * 10, actual_num);
            }
            printNumber(rest * d_by + next_num, d_by, actual_num);
        }
    }

    public static void main(String[] args) {
        printNumber(1033 , 10 , 1033);


    }
}
