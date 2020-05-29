package pract.tree.easy;

import java.util.TreeMap;

public class VerticalSum {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static void fillMap(Node node, int vd, TreeMap<Integer, Integer> mp) {
        if (node != null) {
            mp.put(vd, (mp.containsKey(vd) ? mp.get(vd) + node.data : node.data));
            fillMap(node.left, vd - 1, mp);
            fillMap(node.right, vd + 1, mp);
        }
    }
    static public void verticalSum(Node root) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        fillMap(root, 0, tm);
        tm.values().forEach(x -> System.out.print(x + " "));

    }


    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.right.left = new Node(6);
        n.right.right = new Node(7);
        verticalSum(n);

    }
}
