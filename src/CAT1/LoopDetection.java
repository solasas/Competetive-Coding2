package CAT1;

import java.util.*;

class LoopDetection {

    static Node head = null;   // class-level head

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void addFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    static boolean CheckLoop(Node h) {
        Node slow = h, fast = h;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            int n = in.nextInt();

            if (n == -1)
                break;

            addFirst(n);
        }

        // Making loop
        if (head != null && head.next != null) {

            Node i = head;

            while (i.next != null)
                i = i.next;

            i.next = head.next;
        }

        if (CheckLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}