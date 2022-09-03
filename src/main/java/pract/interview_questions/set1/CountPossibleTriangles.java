//package pract.interview_questions.set1;
//
//import java.util.Arrays;
//
//public class CountPossibleTriangles {
//    static int count(int[] arr, int n) {
//        Arrays.sort(arr);
//        int count = 0;
//        for (int i = 0; i < n - 2; i++) {
//            int j = i + 1;
//            int k = n - 1;
//            while (j < k) {
//                if (arr[i] + arr[j] < arr[k]) {
//                    j++;
//                } else if (arr[i] + arr[j] > arr[k]) {
//                    count++;
//                    k--;
//                } else {
//                    k--;
//                }
//            }
//        }
//
//
//    }
//}
