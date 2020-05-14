package pract.queue.medium;

import java.util.HashMap;

public class LRUCache {
    static class Node {
        int v;
        int k;
        Node prev;
        Node next;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    int cap;
    Node root = null;
    Node lastPointer = null;
    HashMap<Integer, Node> mp;

    LRUCache(int cap) {
        this.cap = cap;
        mp = new HashMap<Integer, Node>();
    }


    private void addFirstPosition(Node newNode) {
        if (root == null) {
            root = lastPointer = newNode;
        } else {
            newNode.next = root;
            root.prev = newNode;
            root = newNode;
        }
    }

    private Node deleteLeastUsedItem() {
        if (root == lastPointer) {
            Node temp = root;
            root = lastPointer = null;
            return temp;
        } else {
            Node temp = lastPointer;
            Node prev = lastPointer.prev;

            prev.next = null;
            lastPointer.prev = null;
            lastPointer = prev;
            return temp;
        }
    }

    private void deleteNode(Node n) {
        if (n == root) {
            root = root.next;
        } else if (n == lastPointer) {
            deleteLeastUsedItem();
        } else {
            Node prev = n.prev;
            Node next = n.next;
            prev.next = next;
            next.prev = prev;
        }

    }

    void set(int key, int value) {
        if (!mp.containsKey(key)) {
            Node newNode = new Node(key, value);
            if (cap > 0) {
                cap--;
                addFirstPosition(newNode);
            } else {
                Node item = deleteLeastUsedItem();
                mp.remove(item.k);
                addFirstPosition(newNode);
            }
            mp.put(key, newNode);
        } else {
            Node usedItem = mp.get(key);
            deleteNode(usedItem);
            usedItem.v = value;
            addFirstPosition(usedItem);
            mp.put(key, usedItem);
        }

    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        } else {
            Node currentNode = mp.get(key);
            if (currentNode == root) {
                return currentNode.v;
            } else {
                deleteNode(currentNode);
                addFirstPosition(currentNode);
            }
            return currentNode.v;
        }
    }

    public void print() {
        Node head = root;
        while (head != null) {
            System.out.println("(" + head.k + "," + head.v + ")");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);

    }
}
