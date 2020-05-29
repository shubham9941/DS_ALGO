package pract.tree.medium;

import java.util.HashMap;

public class CloneBinaryTree {
    static class Tree {
        int data;
        Tree left, right, random;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
            random = null;
        }
    }

    static HashMap<Integer, Integer> rmp = new HashMap<>();
    static HashMap<Integer, Tree> clonemp = new HashMap<>();

    public static Tree cloneTree(Tree tree) {
        if (tree == null) {
            return null;
        }
        Tree n = new Tree(tree.data);
        if (tree.random != null) {
            rmp.put(tree.data, tree.random.data);
        }
        clonemp.put(n.data, n);
        n.left = cloneTree(tree.left);
        n.right = cloneTree(tree.right);
        return n;

    }

    public static void setRandom(Tree tree) {
        if (tree != null) {
            setRandom(tree.left);
            if (rmp.containsKey(tree.data)) {
                tree.random = clonemp.get(rmp.get(tree.data));
            }
            setRandom(tree.right);
        }
    }

    public static Tree getClone(Tree tree) {
        rmp = new HashMap<>();
        clonemp = new HashMap<>();
        Tree clonedTree = cloneTree(tree);
        setRandom(clonedTree);
        return clonedTree;


    }

    public static void traverse(Tree node) {
        if (node != null) {
            traverse(node.left);
            System.out.println(node.data);
            if (node.random != null) {
                System.out.println("Random: " + node.random.data);
            }
            traverse(node.right);
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        Tree left = new Tree(2);
        Tree right = new Tree(3);


        root.left = left;
        root.right = right;


        root.random = right;
        right.random = left;

        cloneTree(root);

        traverse(getClone(root));


    }
}
