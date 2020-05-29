package pract.tree.easy;

public class RootToLeafPathSum {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static boolean hasPathSum(Node node, int sum)
    {
        if (node == null)
            return sum == 0;
        return hasPathSum(node.left, sum - node.data) ||
                hasPathSum(node.right, sum - node.data);
    }


    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.right.left = new Node(6);

        System.out.print(hasPathSum(n , 9));
    }


}
