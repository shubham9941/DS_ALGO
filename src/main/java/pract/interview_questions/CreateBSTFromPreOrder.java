package pract.interview_questions;

public class CreateBSTFromPreOrder {

    static class Node {
        Node left;
        Node right;
        int v;

        Node(int v) {
            this.v = v;
        }
    }

    static int find(int[] arr, int l, int r) {
        int k = l ;
        while (k <= r && arr[l] >= arr[k]){
            k++;
        }
//        System.out.println("l = " + l);
        return k;
    }

    static Node create(int[] arr, int l, int r) {
        System.out.println("l = " + l + " r = " + r);
        if (l <= r) {
            Node n = new Node(arr[l]);
            int nextIndex = find(arr, l, r);
            n.left = create(arr, l + 1, nextIndex - 1);
            n.right = create(arr, nextIndex, r);
            return n;
        }
        return null;

    }

    static void travInOrder(Node root) {
        if (root != null) {
            travInOrder(root.left);
            System.out.print(root.v + " ");
            travInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 1, 7, 40, 50};
        travInOrder(create(arr , 0 , arr.length-1));

    }
}
