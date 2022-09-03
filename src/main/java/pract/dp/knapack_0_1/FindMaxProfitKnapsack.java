package pract.dp.knapack_0_1;

public class FindMaxProfitKnapsack {

    // do same using matrix
    static int knapsack(int[] weight, int[] profit, int n, int knapsackSize) {
        if (n == 0 || knapsackSize == 0) {
            return 0;
        }
        if (weight[n - 1] > knapsackSize) {
            return knapsack(weight, profit, n - 1, knapsackSize);
        }

        return Math.max(
                profit[n - 1] + knapsack(weight, profit, n - 1, knapsackSize - weight[n - 1]),
                knapsack(weight, profit, n - 1, knapsackSize)
        );
    }

    public static void main(String[] args) {

        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(wt, val, n , W));

    }
}
