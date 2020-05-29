package pract.tree.easy;

/**
 * Given a Binary tree of size N . Find the level in binary tree which has the maximum number of nodes. The root is at level 0. If two or more levels have same number of maximum nodes , then print smallest level.
 * Input:
 * First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below:
 */

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNodeLevel {

    /* A binary tree Node has data, pointer
    to left child and a pointer to right
    child */
    static class Node {
        int data;
        Node left;
        Node right;
    }

    /* Helper function that allocates a new node with the
    given data and NULL left and right pointers. */
    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return (node);
    }

    // function to find the level
// having maximum number of Nodes
    static int maxNodeLevel(Node root) {
        if (root == null)
            return -1;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Current level
        int level = 0;

        // Maximum Nodes at same level
        int max = Integer.MIN_VALUE;

        // Level having maximum Nodes
        int level_no = 0;

        while (true) {
            // Count Nodes in a level
            int NodeCount = q.size();

            if (NodeCount == 0)
                break;

            // If it is maximum till now
            // Update level_no to current level
            if (NodeCount > max) {
                max = NodeCount;
                level_no = level;
            }

            // Pop complete current level
            while (NodeCount > 0) {
                Node Node = q.peek();
                q.remove();
                if (Node.left != null)
                    q.add(Node.left);
                if (Node.right != null)
                    q.add(Node.right);
                NodeCount--;
            }

            // Increment for next level
            level++;
        }

        return level_no;
    }

    // Driver program to test above
    public static void main(String[] args) {
        // binary tree formation
        Node root = newNode(2);
        root.left = newNode(1);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(6);
        root.right.right = newNode(8);
        root.left.right.left = newNode(5);

        System.out.println("Level having maximum number of Nodes : " + maxNodeLevel(root));
    }
}
