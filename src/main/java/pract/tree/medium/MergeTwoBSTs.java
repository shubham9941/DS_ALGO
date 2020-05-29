package pract.tree.medium;

//Note time complexity should be O(N+M) and space complexity 0(h1+h2)

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBSTs {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }


    static void addPostOrder(Node n, Stack<Node> stk) {
        if (n != null) {
            addPostOrder(n.right, stk);
            stk.push(n);
            addPostOrder(n.left, stk);
        }
    }

    public static List<Integer> merge(Node root1, Node root2) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stk1 = new Stack<Node>();
        Stack<Node> stk2 = new Stack<Node>();
        addPostOrder(root1, stk1);
        addPostOrder(root2, stk2);
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            if (stk1.peek().data < stk2.peek().data) {
                list.add(stk1.pop().data);
            } else if (stk1.peek().data > stk2.peek().data) {
                list.add(stk2.pop().data);
            } else {
                list.add(stk1.pop().data);
                list.add(stk2.pop().data);
            }
        }
        while (!stk1.isEmpty()) {
            list.add(stk1.pop().data);
        }
        while (!stk2.isEmpty()) {
            list.add(stk2.pop().data);
        }

        return list;


    }

    public static void main(String[] args) {

        Node n1 = new Node(5);
        n1.left = new Node(3);
        n1.right = new Node(6);

        n1.left.left = new Node(2);
        n1.left.right = new Node(4);


        Node n2 = new Node(2);
        n2.left = new Node(1);
        n2.right = new Node(3);

        n2.right.right = new Node(7);
        n2.right.right.left = new Node(6);

        List l = merge(n1, n2);
        l.forEach(x -> System.out.print(x + " "));

    }
}
