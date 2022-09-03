package pract.interview_questions.sde_2;

public class printNodeAt_k_Distance {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static void printByLevel(Node root, int cL, int toL) {
        if (root != null && toL >= 0) {
            if (cL == toL) {
                System.out.print(root.data + " ");
            }
            printByLevel(root.left, cL + 1, toL);
            printByLevel(root.right, cL + 1, toL);
        }
    }

   static int printAtKthDis(Node root, int taget, int dis) {
        if (root == null) {
            return -1;
        }
        if (root.data == taget) {
            printByLevel(root, 0, dis);
            return dis - 1;
        }

        int lr = printAtKthDis(root.left, taget, dis);

//        System.out.println("lr = " + lr);

        if (lr != -1) {
            if (lr == 0) {
                System.out.print(root.data + " ");
                return -1;
            }
            printByLevel(root.right, 1, lr);
            return lr - 1;
        }

        int rr = printAtKthDis(root.right, taget, dis);

        if (rr != -1) {
            if (rr == 0) {
                System.out.print(root.data + " ");
                return -1;
            }
            printByLevel(root.left, 1, rr);
            return rr - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.left.right.right.right = new Node(15);

        printAtKthDis(root , 8, 1);


    }
}
