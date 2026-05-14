package CAT1;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class SortBitonicDLL {

    // Step 1: Split the DLL
    static Node split(Node head) {
        Node curr = head;

        while (curr.next != null && curr.data <= curr.next.data) {
            curr = curr.next;
        }

        Node second = curr.next;
        if (second != null) second.prev = null;
        curr.next = null;

        return second;
    }

    // Step 2: Reverse DLL
    static Node reverse(Node head) {
        Node temp = null;
        Node curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null)
            head = temp.prev;

        return head;
    }

    // Step 3: Merge two sorted DLLs
    static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            if (first.next != null) first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null) second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    // Main function
    static Node sortBitonicDLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node second = split(head);
        second = reverse(second);

        return merge(head, second);
    }
}

//1.Find the peak point
//  Where increasing stops and decreasing starts
//2.Split the list into 2 parts
//First half → already sorted (ascending)
//  Second half → sorted but in descending order
//3.Reverse the second half
//  Now both halves are sorted in ascending order
//4.Merge the two sorted DLLs
//  Just like merge step of merge sort