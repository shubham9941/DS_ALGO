package pract.array.easy;

public class LeadersInAnArray {
    static void printLeadersInArray(int[] arr, int size) {
        StringBuilder sb = new StringBuilder();

        int leader = arr[size - 1];
//        sb.insert(0 , leader + " ");
        sb.append(leader + " ");
        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                leader = arr[i];
                sb = sb.append(leader + " ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};

        StringBuilder sb = new StringBuilder();
        sb.append("sh");
        System.out.println(sb);
        sb.insert(0, "rahul");
        System.out.println();

//        printLeadersInArray(arr, arr.length);

    }
}
