package pract.bst.easy;

public class ArrayToBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node convert(int[] arr, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            Node n = new Node(arr[mid]);
            n.left = convert(arr, l, mid - 1);
            n.right = convert(arr, mid + 1, r);
            return n;
        }
        return null;
    }

    static void printPreOrder(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            printPreOrder(n.left);
            printPreOrder(n.right);
        }
    }

    public static void main(String[] args) {

        int[]arr = {1, 2, 3, 4, 5, 6, 7};
        Node n = convert(arr , 0 , arr.length-1);
        printPreOrder(n);
    }
}
