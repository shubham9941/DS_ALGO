//package pract.linked_list.medium;
//
//
//
//class Tree
//{
//
//    Node root;
//    Node head;
//    static Node previous;
//
//    void convertToCDLL(Node root) {
//        Node rootRight = null;
//        if (root == null || root == head) {
//            return;
//        }
//        convertToCDLL(root.left);
//
//        if (previous == null) {
//            System.out.println("Hey i m here");
//            previous = head = root;
//            previous.right = root;
//            previous.left = root;
//
//        } else {
//            previous.right = root;
//            root.left = previous;
//            rootRight = root.right;
//            root.right = head;
//            head.left = root;
//            previous = previous.right;
//        }
//
//        convertToCDLL(rootRight);
//
//    }
//
//    Node bTreeToClist(Node root)
//    {
//        convertToCDLL(root);
//        return head;
//    }
//
//    void printCDLL(Node head) {
//        Node temp = head;
//        do {
//            System.out.println(temp.data);
//            temp = temp.right;
//        } while (temp != head);
//    }
//
//    public static void main(String[] args) {
//
//        Tree tree = new Tree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(3);
//        tree.root.right = new Node(2);
////        tree.root.left.left = new Node(25);
////        tree.root.left.right = new Node(30);
////        tree.root.right.left = new Node(36);
//
////        tree.convertToDLL(tree.root);
////        tree.printDLL(tree.head);
//        Node res  = tree.bTreeToClist(tree.root);
//        tree.printCDLL(res);
//
//
//    }
//
//}