package pract.tree.easy;

public class ConstructTreeFromInorderAndPreOrder {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static int preIndex;

    static int search(int[] ino, int num, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (ino[i] == num) {
                return i;
            }
        }
        throw new RuntimeException("No index found in inorder array for element " + num);
    }

    public static Node buildTree(int ino[], int pre[], int st, int end) {
        if (st <= end) {
            int index = search(ino, pre[preIndex++], st, end);
            Node n = new Node(ino[index]);
            n.left = buildTree(ino, pre, st, index - 1);
            n.right = buildTree(ino, pre, index + 1, end);
            return n;
        }
        return null;
    }

    public static void postOderTrav(Node n) {
        if (n != null) {
            postOderTrav(n.left);
            postOderTrav(n.right);
            System.out.print(n.data + " ");
        }
    }

    public static void main(String[] args) {

        int[] inOrder = {3, 1, 4, 0, 5, 2, 6};
        int[] preOrder = {0, 1, 3, 4, 2, 5, 6};

        preIndex = 0;

        Node res = buildTree(inOrder, preOrder, 0, inOrder.length - 1);
        postOderTrav(res);
//        System.out.print(res.data);

    }
}
