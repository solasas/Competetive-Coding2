package CAT1;



public class MergeSortDll {
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    // Step 1: Find middle using slow-fast pointer
    static Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Step 2: Split DLL into two halves
    static Node split(Node head) {
        Node mid = getMiddle(head);
        Node second = mid.next;

        mid.next = null;
        if (second != null) second.prev = null;

        return second;
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

    // Main Merge Sort function
    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }
}