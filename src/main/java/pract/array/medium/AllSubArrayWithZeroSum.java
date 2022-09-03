package pract.array.medium;

import java.io.*;
import java.util.*;

// User defined pair class
class Pair {
    int first, second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }
}

public class AllSubArrayWithZeroSum {
    // Function to print all subarrays in the array which
    // has sum 0
    static ArrayList<Pair> findSubArrays(int[] arr, int n) {
        // create an empty map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // create an empty vector of pairs to store
        // subarray starting and ending index
        ArrayList<Pair> out = new ArrayList<>();

        // Maintains sum of elements so far
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // add current element to sum
            sum += arr[i];

            // if sum is 0, we found a subarray starting
            // from index 0 and ending at index i
            if (sum == 0)
                out.add(new Pair(0, i));
            ArrayList<Integer> al = new ArrayList<>();

            // If sum already exists in the map there exists
            // at-least one subarray ending at index i with
            // 0 sum
            if (map.containsKey(sum)) {
                // map[sum] stores starting index of all subarrays
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++) {
                    out.add(new Pair(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return out;
    }

    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out) {
        for (int i = 0; i < out.size(); i++) {
            Pair p = out.get(i);
            System.out.println("Subarray found from Index "
                    + p.first + " to " + p.second);
        }
    }

    // Driver code
    public static void main(String args[]) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;

        ArrayList<Pair> out = findSubArrays(arr, n);

        // if we did not find any subarray with 0 sum,
        // then subarray does not exists
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            print(out);
    }
}

