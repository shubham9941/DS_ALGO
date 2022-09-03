package pract.interview_questions;

import java.util.*;

class HightOfBinaryTree {
    static int height;

    /* Function to find index of value
    in the InOrder Traversal array */
    static int search(int arr[], int strt,
                      int end, int value) {
        for (int i = strt; i <= end; i++)
            if (arr[i] == value)
                return i;
        return -1;
    }

    // Function to calculate the height
// of the Binary Tree
    static int getHeight(int in[], int level[],
                         int start, int end, int n) {

        // Base Case
        if (start > end)
            return 0;

        // Get index of current root in InOrder Traversal
        int getIndex = search(in, start, end, level[0]);

        if (getIndex == -1)
            return 0;

        System.out.println("index = " + getIndex);

        // Count elements in Left Subtree
        int leftCount = getIndex - start;

        // Count elements in right Subtree
        int rightCount = end - getIndex;

        // Declare two arrays for left and
        // right subtrees
        int[] newLeftLevel = new int[leftCount];
        int[] newRightLevel = new int[rightCount];

        int lheight = 0, rheight = 0;
        int k = 0;

        // Extract values from level order traversal array
        // for current left subtree
        for (int i = 0; i < n; i++) {
            for (int j = start; j < getIndex; j++) {
                if (level[i] == in[j]) {
                    newLeftLevel[k] = level[i];
                    k++;
                    break;
                }
            }
        }

        k = 0;

        // Extract values from level order traversal array
        // for current right subtree
        for (int i = 0; i < n; i++) {
            for (int j = getIndex + 1; j <= end; j++) {
                if (level[i] == in[j]) {
                    newRightLevel[k] = level[i];
                    k++;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(newLeftLevel));
        System.out.println(Arrays.toString(newRightLevel));

        // Recursively call to calculate
        // height of left Subtree
        if (leftCount > 0)
            lheight = getHeight(in, newLeftLevel, start,
                    getIndex - 1, leftCount);

        // Recursively call to calculate
        // height of right Subtree
        if (rightCount > 0)
            rheight = getHeight(in, newRightLevel,
                    getIndex + 1, end, rightCount);

        // Current height
        height = Math.max(lheight + 1, rheight + 1);

        // Delete Auxiliary arrays
        newRightLevel = null;
        newLeftLevel = null;

        // return height
        return height;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int in[] = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};
        int n = in.length;

        height = 0;

        System.out.println(getHeight(in, level, 0, n - 1, n));
    }
}

// This code is contributed by Rajput-Ji
