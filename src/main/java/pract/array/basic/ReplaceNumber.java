package pract.array.basic;

// Replace all ‘0’ with ‘5’ in an input Integer
/*
 102 - 152
 1020 - 1525
 */
public class ReplaceNumber {
    static int replace(int num) {
        if(num == 0){
            return num;
        }
        int remain = (num % 10 == 0 ? 5 : num % 10);
        return replace(num / 10) * 10 + remain;

    }

    public static void main(String[] args) {
        System.out.println(replace(1004));

    }
}
