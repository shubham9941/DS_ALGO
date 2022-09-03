package pract.interview_questions;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

   static class Node {
        Node left;
        Node right;
        Node nextRight ;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

   static void connectLevels(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = size; i >= 1; i--) {
                Node current = q.poll();
                if(current.left!=null){
                    q.add(current.left);
                }
                if(current.right!=null){
                    q.add(current.right);
                }

                if (i != 1) {
                    current.nextRight = q.peek();
                }
            }
        }
    }


    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        connectLevels(root);

        System.out.println("Following are populated nextRight pointers in "
                + "the tree"
                + "(-1 is printed if there is no nextRight)");
        int a = root.nextRight != null ? root.nextRight.data : -1;
        System.out.println("nextRight of " + root.data + " is "
                + a);
        int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.data + " is "
                + b);
        int c = root.right.nextRight != null ? root.right.nextRight.data : -1;
        System.out.println("nextRight of " + root.right.data + " is "
                + c);
        int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.left.data + " is "
                + d);

    }
}
