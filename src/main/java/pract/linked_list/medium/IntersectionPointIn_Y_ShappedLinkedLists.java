package pract.linked_list.medium;

/**
 * Method 1(Simply use two loops)
 * Use 2 nested for loops. The outer loop will be for each node of the 1st list and inner loop will be for 2nd list. In the inner loop, check if any of nodes of the 2nd list is same as the current node of the first linked list. The time complexity of this method will be O(M * N) where m and n are the numbers of nodes in two lists.
 *
 *
 *
 * Method 2 (Mark Visited Nodes)
 * This solution requires modifications to basic linked list data structure. Have a visited flag with each node. Traverse the first linked list and keep marking visited nodes. Now traverse the second linked list, If you see a visited node again then there is an intersection point, return the intersecting node. This solution works in O(m+n) but requires additional information with each node. A variation of this solution that doesn’t require modification to the basic data structure can be implemented using a hash. Traverse the first linked list and store the addresses of visited nodes in a hash. Now traverse the second linked list and if you see an address that already exists in the hash then return the intersecting node.
 *
 * Method 3(Using difference of node counts)
 *
 * Get count of the nodes in the first list, let count be c1.
 * Get count of the nodes in the second list, let count be c2.
 * Get the difference of counts d = abs(c1 – c2)
 * Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
 * Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
 */

class IntersectionPointIn_Y_ShappedLinkedLists {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /*function to get the intersection point of two linked
    lists head1 and head2 */
    int getNode()
    {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return _getIntesectionNode(d, head1, head2);
        }
        else {
            d = c2 - c1;
            return _getIntesectionNode(d, head2, head1);
        }
    }

    /* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
    int _getIntesectionNode(int d, Node node1, Node node2)
    {
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    /*Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(Node node)
    {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args)
    {
        IntersectionPointIn_Y_ShappedLinkedLists list = new IntersectionPointIn_Y_ShappedLinkedLists();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + list.getNode());
    }
}

// This code has been contributed by Mayank Jaiswal


