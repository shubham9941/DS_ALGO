package pract.interview_questions;

public class ReversePair {

    static class Node {
        Node next;
        int v;

        Node(int v) {
            this.v = v;
        }
    }

  static Node reversePair(Node root) {
        Node next = root.next;
        root.next = null;
        next.next = root;
        return next;

    }

    static  Node reverseByPair(Node root) {
        if (root == null) {
            return null;
        }
        if (root.next == null) {
            return root;
        }

        Node next_next = root.next.next;
        root.next.next = null;

        Node n = reversePair(root);
//        print(n);

        root.next = reverseByPair(next_next);
        return n;
    }

    static  void print(Node root) {
        while (root != null) {
            System.out.println(root.v);
            root = root.next;
        }
    }

    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.next = new Node(2);
//        root.next.next = new Node(3);
//        root.next.next.next= new Node(4);
//        root.next.next.next.next= new Node(5);
//
//        print(reverseByPair(root));
        int a = 'a';
        int A = 'A';
        System.out.println(a);
        System.out.println(A);

    }
}
