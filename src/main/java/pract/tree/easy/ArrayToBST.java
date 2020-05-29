package pract.tree.easy;

/**
 * Given a sorted array. Write a program that creates a Balanced Binary Search Tree using array elements.
 * If there are N elements in array, then floor(n/2)'th element should be chosen as root and same should be followed recursively.
 */

public class ArrayToBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node create(int[] arr, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            Node newNode = new Node(arr[mid]);
            newNode.left = create(arr, l, mid - 1);
            newNode.right = create(arr, mid + 1, r);
            return newNode;
        } else return null;
    }

    static void preOrderPrint(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            preOrderPrint(n.left);
            preOrderPrint(n.right);
        }
    }

    public static void main(String[] args) {

        int[]arr = {1, 2, 3, 4, 5, 6, 7};
        preOrderPrint(create(arr , 0 , arr.length-1));

    }
}
