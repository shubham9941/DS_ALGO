package pract.tree.medium;

public class LargestBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class NodeInfo {
        boolean isBST;
        int min;
        int max;
        int l;

        NodeInfo(int min, int max, int l, boolean isBst) {
            this.min = min;
            this.max = max;
            this.l = l;
            this.isBST = isBst;
        }
    }


    static NodeInfo getLagestBST(Node root) {
        if (root == null) return null;

        if (root.left == null && root.right == null) return new NodeInfo(root.data, root.data, 1, true);


        if (root.right == null) {
            NodeInfo leftInfo = getLagestBST(root.left);
            return (leftInfo.isBST && leftInfo.max < root.data) ?
                    new NodeInfo(leftInfo.min, root.data, leftInfo.l + 1, true) :
                    new NodeInfo(0, 0, leftInfo.l, false);
        }

        if (root.left == null) {
            NodeInfo rightInfo = getLagestBST(root.right);
            return (rightInfo.isBST && rightInfo.min > root.data) ?
                    new NodeInfo(root.data, rightInfo.max, rightInfo.l + 1, true) :
                    new NodeInfo(0, 0, rightInfo.l, false);

        }

        NodeInfo leftInfo = getLagestBST(root.left);
        NodeInfo righInfo = getLagestBST(root.right);

        if (leftInfo.isBST && righInfo.isBST && root.data > leftInfo.max && root.data < righInfo.min) {
            return new NodeInfo(leftInfo.min, righInfo.max, leftInfo.l + righInfo.l + 1, true);
        }
        return new NodeInfo(0, 0, Math.max(leftInfo.l, righInfo.l), false);

    }

    static int largestBst(Node root) {
        if (root == null) {
            return 0;
        }
        return getLagestBST(root).l;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(1);
//        root.right = new Node(60);
//        root.left = new Node(10);
//        root.left.left = new Node(5);
//        root.left.right = new Node(20);
//        root.right.left = new Node(55);
//        root.right.left.left = new Node(45);
//        root.right.right = new Node(70);
//        root.right.right.left = new Node(65);
//        root.right.right.right = new Node(80);
        System.out.print(largestBst(root));


    }
}
