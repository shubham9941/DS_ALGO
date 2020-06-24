package pract.bst.hard;

public class RedBlackTree {

    Node root;

    static class Node {
        int data;
        int height;
        String color;
        Node left, right;
        boolean isRBTree;

        Node(int item) {
            data = item;
            left = right = null;
            height = 1;
            color = "R";
            isRBTree = true;
        }
    }

    private String color(Node n) {
        if (n == null) {
            return "B";
        }
        return n.color;
    }

    private Node rightRotate(Node root) {
        Node new_root = root.left;
        Node new_root_right = new_root.right;
        new_root.right = root;
        root.left = new_root_right;
        return new_root;

    }

    private Node leftRotate(Node root) {
        Node new_root = root.right;
        Node new_root_left = new_root.left;

        new_root.left = root;
        root.right = new_root_left;
        return new_root;
    }

    private void changeColorAfterLeftRotation(Node root) {
        root.color = "B";
        root.left.color = "R";
    }

    private void changeColorAfterRightRotation(Node root) {
        root.color = "B";
        root.right.color = "R";
    }

    private Node makeBalance(Node root) {
        if (color(root.left).equals("R") && color(root.right).equals("R")) {
            root.left.color = "B";
            root.right.color = "B";
            root.color = "R";
            return root;
        } else {
            if (color(root.right).equals("R")) {

                //R.R case
                if (color(root.right.right).equals("R")) {
//                    System.out.print("R.R case");
                    root = leftRotate(root);
                    changeColorAfterLeftRotation(root);
                    return root;
                }
                // R.L case
//                System.out.print("R.L case");
                root.right = rightRotate(root.right);
                root = leftRotate(root);
                changeColorAfterLeftRotation(root);
                return root;

            } else if (color(root.left).equals("R")) {
                //L.L case
                if (color(root.left.left).equals("R")) {
                    root = rightRotate(root);
                    changeColorAfterRightRotation(root);
                    return root;
                }
                // L.R case
                System.out.println("L.R case and root = " + root.data);
                root.left = leftRotate(root.left);
                root = rightRotate(root);
                changeColorAfterRightRotation(root);
                return root;
            }
        }
        return root;
    }

    private Node insertToRB(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insertToRB(root.left, key);
        } else if (key > root.data) {
            root.right = insertToRB(root.right, key);
        }

        if (root.left != null && !root.left.isRBTree) {
            root.left.isRBTree = true;
            root = makeBalance(root);
        }

        if (root.right != null && !root.right.isRBTree) {
            root.right.isRBTree = true;
            root = makeBalance(root);
        }

        if (color(root).equals("R") && (color(root.left).equals("R") || color(root.right).equals("R"))) {
            root.isRBTree = false;
        }

        return root;

    }

    void insert(int key) {
        root = insertToRB(root, key);
        root.color = "B";
    }

    void preOrderTrav(Node root) {
        if (root != null) {
            System.out.println(root.data + " color = " + root.color + " isRB " + root.isRBTree);
            preOrderTrav(root.left);
            preOrderTrav(root.right);
        }

    }

    public static void main(String[] args) {

        RedBlackTree rb = new RedBlackTree();
//        rb.insert(10);
//        rb.insert(20);
//        rb.insert(-10);
//        rb.insert(15);
//        rb.insert(17);
//        rb.insert(40);
//        rb.insert(50);
//        rb.insert(60);

        rb.insert(10);
        rb.insert(18);
        rb.insert(7);
        rb.insert(15);
        rb.insert(16);
        rb.insert(30);
        rb.insert(25);
        rb.insert(40);
        rb.insert(60);
        rb.insert(2);
        rb.insert(1);
        rb.insert(70);


        rb.preOrderTrav(rb.root);



    }
}
