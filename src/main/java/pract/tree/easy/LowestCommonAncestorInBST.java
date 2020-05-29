package pract.tree.easy;

/**
 * Note : it is kind of root node of its child Node
 */
public class LowestCommonAncestorInBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Node search(Node root, int n) {
        if (root == null) {
            return null;
        }
        if (n < root.data) {
            return search(root.left, n);
        } else if (n > root.data) {
            return search(root.right, n);
        } else {
            return root;
        }
    }

    static Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (n1 > root.data && n2 > root.data) {
            return LCA(root.right, n1, n2);
        } else if (n1 < root.data && n2 < root.data) {
            return LCA(root.left, n1, n2);
        } else {
            // Note: If you required that node that is searched for should be there,
            // then search the node otherwise return the root direct from here
            Node isN1Found = search(root, n1);
            Node isN2Found = search(root, n2);
            if (isN1Found != null && isN2Found != null) {
                return root;
            } else return null;
        }
    }

    public static void main(String[] args) {

        Node n = new Node(5);

        n.left = new Node(4);
        n.right = new Node(6);

        n.left.left = new Node(3);

        n.right.right = new Node(7);
        n.right.right.right = new Node(8);




        Node res = LCA(n , 6, 8);
        if(res!=null){
            System.out.println(res.data);
        }

    }
}
