package pract.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumInBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    int printMaxSumByLevel(Queue<Node> qu, int size, int max) {
        int sum = 0;
        while (size-- > 0) {
            Node current = qu.poll();
            sum += current.data;
            if (current.left != null)
                qu.add(current.left);
            if (current.right != null)
                qu.add(current.right);
        }
        if (sum > max)
            max = sum;
        if (qu.size() > 0) {
            return printMaxSumByLevel(qu, qu.size(), max);
        }
        return max;
    }

    public int maxLevelSum(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        return printMaxSumByLevel(qu, qu.size(), Integer.MIN_VALUE);
    }
}
