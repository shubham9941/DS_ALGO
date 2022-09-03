package pract.interview_questions;

public class PreOrderToBST {

    static class Node {
        Node left;
        Node right;
        int v;

        Node(int v) {
            this.v = v;
        }
    }

    static int i = 0;

    static Node preToBstUtil(int[]pre , int n , int min , int max){
        if(i == n){
            return null;
        }

        Node root = null;

        if(pre[i] > min && pre[i] < max){
            root = new Node(pre[i]);
            i++;
            root.left = preToBstUtil(pre , n, min, root.v);
            root.right = preToBstUtil(pre , n, root.v , max);
        }

        return root;
    }

    static Node preToBst(int[]pre , int n){
        i = 0;
        return preToBstUtil(pre , n , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    static Node postToBstUtil(int[]pre , int n , int min , int max){
//        System.out.println("i = " + i);

        if(i < 0){
            return null;
        }


//        System.out.println("min = " + min);
//        System.out.println("min = " + max);

        Node root = null;

        if(pre[i] > min && pre[i] < max){
            root = new Node(pre[i]);
            i--;
            root.right = postToBstUtil(pre , n, root.v , max);
            root.left = postToBstUtil(pre , n, min, root.v);
        }

        return root;
    }

    static Node postToBst(int[]pre , int n){
        i = n-1;
        return postToBstUtil(pre , n , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    static void printInOrder(Node root){
        if(root!=null){
            printInOrder(root.left);
            System.out.print(root.v + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
//        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int post[] = new int[]{1, 7, 5, 50, 40, 10};
//        printInOrder(preToBst(pre , pre.length));
        printInOrder(postToBst(post , post.length));
    }
}
