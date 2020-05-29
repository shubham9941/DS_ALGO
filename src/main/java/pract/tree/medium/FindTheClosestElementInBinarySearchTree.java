package pract.tree.medium;


// Recursive Java program to find key closest to k
// in given Binary Search Tree.

class FindTheClosestElementInBinarySearchTree
{

    static int min_diff, min_diff_key;

    static class Node
    {
        int key;

        Node left, right;
    }

    static Node newnode(int key)
    {

        Node node = new Node();
        node.key = key;
        node.left = node.right = null;
        return (node);
    }

    static void maxDiffUtil(Node ptr, int k)
    {
        if (ptr == null)
            return ;

        // If k itself is present
        if (ptr.key == k)
        {
            min_diff_key = k;
            return;
        }

        // update min_diff and min_diff_key by checking
        // current node value
        if (min_diff > Math.abs(ptr.key - k))
        {
            min_diff = Math.abs(ptr.key - k);
            min_diff_key = ptr.key;
        }

        // if k is less than ptr.key then move in
        // left subtree else in right subtree
        if (k < ptr.key)
            maxDiffUtil(ptr.left, k);
        else
            maxDiffUtil(ptr.right, k);
    }

    // Wrapper over maxDiffUtil()
    static int maxDiff(Node root, int k)
    {
        // Initialize minimum difference
        min_diff = 999999999; min_diff_key = -1;

        // Find value of min_diff_key (Closest key
        // in tree with k)
        maxDiffUtil(root, k);

        return min_diff_key;
    }

    // Driver program to run the case
    public static void main(String args[])
    {

        Node root = newnode(30);
        root.left = newnode(6);
        root.right = newnode(100);
//        root.left.left = newnode(3);
//        root.left.right = newnode(6);
//        root.left.right.left = newnode(5);
//        root.left.right.right = newnode(7);
//        root.right.right = newnode(22);
//        root.right.right.left = newnode(20);
        int k = 15;
        System.out.println( maxDiff(root, k));

    }
}
//contributed by Arnab Kundu
