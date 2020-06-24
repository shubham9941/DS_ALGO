package pract.tree.hard;

public class AVLTree {

    Node root;

    static class Node {
        int data;
        int height;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
            height = 1;
        }
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.println("root =  " + root.data + " and height = " + root.height);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private Node findMin(Node n) {
        if (n == null) {
            return null;
        }
        if (n.left == null) {
            return n;
        }
        return findMin(n.left);
    }

    private Node leftRotate(Node root) {
        Node new_root = root.right;
        Node new_root_left = new_root.left;

        new_root.left = root;
        root.right = new_root_left;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        new_root.height = Math.max(height(new_root.left), height(new_root.right)) + 1;

        return new_root;
    }

    private Node rightRotate(Node root) {
        Node new_root = root.left;
        Node new_root_right = new_root.right;
        new_root.right = root;
        root.left = new_root_right;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        new_root.height = Math.max(height(new_root.left), height(new_root.right)) + 1;

        return new_root;

    }

    private int getBalance(Node n) {
        return (height(n.left) - height(n.right));
    }

    private int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                Node min = findMin(root.right);
                root.data = min.data;
                root.right = deleteNode(root.right, min.data);
            }
        }


        if (root == null) {
            return root;
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1) {
            if (getBalance(root.left) >= 0) { // L.L CASE
                return rightRotate(root);
            }
            // L.R CASE
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1) {
            if (getBalance(root.right) <= 0) { // R.R CASE
                return leftRotate(root);
            }
            //R.L CASE
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;


    }


    Node insertToAVL(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data) {
            root.left = insertToAVL(root.left, key);
        } else {
            root.right = insertToAVL(root.right, key);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1) {
            if (key < root.left.data) { // L.L CASE
                return rightRotate(root);
            }
            // L.R CASE
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1) {
            if (key > root.right.data) { // R.R CASE
                return leftRotate(root);
            }
            //R.L CASE
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }


    void insert(int key) {
        root = insertToAVL(root, key);
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(10);
        tree.insert(15);

        tree.deleteNode(tree.root, 6);

        tree.preOrder(tree.root);
    }
}
