package pract.tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void serialize(Node root, ArrayList<Integer> al) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node fist = queue.poll();
            if (fist == null) {
                al.add(-1);
            } else {
                al.add(fist.data);
                queue.add(fist.left);
                queue.add(fist.right);
            }
        }

    }

    public static Node deSerialize(ArrayList<Integer> al) {
        Node root = new Node(al.get(0));
        al.remove(0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node first = queue.poll();
                int lc = al.get(0);
                al.remove(0);
                int rc = al.get(0);
                al.remove(0);
                if (lc != -1) {
                    Node leftNode = new Node(lc);
                    first.left = leftNode;
                    queue.add(leftNode);
                }
                if (rc != -1) {
                    Node rightNode = new Node(rc);
                    first.right = rightNode;
                    queue.add(rightNode);

                }
            }
        }

        return root;

    }

    static void traversal(Node n) {
        if (n != null){
            traversal(n.left);
            System.out.print(n.data + " ");
            traversal(n.right);
        }
    }


    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.right.right = new Node(6);

        n.right.right.left = new Node(7);
        n.right.right.right = new Node(8);

        ArrayList<Integer> al = new ArrayList<Integer>();
        traversal(n);
        serialize(n, al);
        System.out.println(al);
        traversal(deSerialize(al));


    }
}
