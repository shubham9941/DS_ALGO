package pract.tree.medium;

public class ConstructTreeFromPreorderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static int PRE_INDEX = -1;

    static Node construct(int n, int pre[], char preLN[]) {
        PRE_INDEX++;
        if (PRE_INDEX < n) {
            Node newNode = new Node(pre[PRE_INDEX]);
            if (preLN[PRE_INDEX] == 'L') {
                return newNode;
            }

            newNode.left = construct(n, pre, preLN);
            newNode.right = construct(n, pre, preLN);
            return newNode;
        }
        return null;
    }

    static Node constructTree(int n, int pre[], char preLN[]) {
        PRE_INDEX = -1;
        return construct(n, pre, preLN);
    }

    static void printInOrder(Node n) {
        if(n!=null){
            printInOrder(n.left);
            System.out.print(n.data + " ");
            printInOrder(n.right);
        }
    }

    public static void main(String[] args) {

        int[] pre = {10, 30, 20, 5, 15};
        char[] preLN = {'N', 'N', 'L', 'L', 'L'};
        printInOrder(constructTree(pre.length, pre, preLN));


    }

}
