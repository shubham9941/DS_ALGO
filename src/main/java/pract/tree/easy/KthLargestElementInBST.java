package pract.tree.easy;

public class KthLargestElementInBST {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int CURRENT_LARGEST_NUMBER;

    static void printKthLargestElement(Node n, int k) {
        if (n != null) {
            printKthLargestElement(n.right, k);
            CURRENT_LARGEST_NUMBER++;
            if (k == CURRENT_LARGEST_NUMBER) {
                System.out.println(n.data);
            } else {
                printKthLargestElement(n.left, k);
            }
        }
    }

    public static void kthLargest(Node root, int k) {
        CURRENT_LARGEST_NUMBER = 0;
        printKthLargestElement(root, k);
    }

    public static void main(String[] args) {

        Node n = new Node(50);
        n.left = new Node(30);
        n.right = new Node(70);

        n.left.left = new Node(20);
        n.left.right = new Node(40);

        n.right.left = new Node(60);
        n.right.right = new Node(80);


        for (int i = 1; i <= 7; i++) {
           kthLargest(n , i);
        }

    }

}
