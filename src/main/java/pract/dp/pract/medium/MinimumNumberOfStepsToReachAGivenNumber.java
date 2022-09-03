package pract.dp.pract.medium;

public class MinimumNumberOfStepsToReachAGivenNumber {

    static int getMinStaps(int curr_pos, int required_steps, int to) {
        if (Math.abs(curr_pos) > to) {
            return Integer.MAX_VALUE - 1;
        }
        if (required_steps - curr_pos == to) {
            return 1;
        }

        return 1 + Integer.min(
                getMinStaps(curr_pos + required_steps, required_steps + 1, to),
                getMinStaps(curr_pos - required_steps, required_steps + 1, to)
        );
    }

    public static void main(String[] args) {
        System.out.print(getMinStaps(0,1,11));
    }
}
