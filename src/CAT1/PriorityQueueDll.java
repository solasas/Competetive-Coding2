package CAT1;

class Node {
    int data;
    int priority;
    Node prev, next;

    Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        prev = next = null;
    }
}

public class PriorityQueueDll {

    Node head = null;

    // Insert in sorted order (higher priority first)
    public void push(int data, int priority) {
        Node newNode = new Node(data, priority);

        // Case 1: Empty list
        if (head == null) {
            head = newNode;
            return;
        }

        // Case 2: Insert at beginning (highest priority)
        if (priority > head.priority) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Case 3: Insert in middle or end
        Node curr = head;
        while (curr.next != null && curr.next.priority >= priority) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    // Remove highest priority element
    public int pop() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int val = head.data;
        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        return val;
    }

    // Peek highest priority
    public int peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
    }
}