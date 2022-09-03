package pract.dp.knapack_0_1;

// subset1 = s1 and subset2 = s2
// given s1 - s2 = diff
// we know s1 + s2 = sum(arr)
// when solve these equations => s1 = (diff + sum(arr)) / 2
// so now problem converted to the count NumberOfSubSetEqualToSum

public class CountTheNumberOfSubsetWithAGivenDifference {

    static int count(int[] arr, int n, int diff) {
        int sum = 0;
        for (int i : arr) sum += i;
        int s1 = (diff + sum) / 2;

        return NumberOfSubSetEqualToSum.findNumberOfSubSet(arr, s1, n);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3}; // 1 count as two diff number
        // res = {1,1,2} {3} , {1,2} {1,3} , {1,2} {1,3}
        System.out.println(count(arr ,arr.length , 1));

    }
}
