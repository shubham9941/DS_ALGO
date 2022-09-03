package pract.interview_questions.sde_2;

public class MinNumberOfJump {

    static int find(int[] arr, int n) {
        if (n == 0 || arr[0] == 0) {
            return 0;
        }
        int[] minJumps = new int[n];
        minJumps[0] = 0;
        minJumps[1] = 1;
        int i = 0;

        for (int j = 2; j < n; ) {
            if (arr[i] + i >= j) {
                minJumps[j] = 1 + minJumps[i];
                j++;
            } else if (arr[i] == 0) {
                return 0;
            } else {
                i++;
            }
        }

        return minJumps[n-1];

    }


    public static void main(String[] args) {

        int[]arr = {1, 1, 1, 1};
        System.out.println(find(arr , arr.length));
    }
}
