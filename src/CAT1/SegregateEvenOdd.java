package CAT1;

public class SegregateEvenOdd {
    public Node oddEvenList(Node head) {
        if (head == null) return null;
        Node odd=head;
        Node even=head.next;
        Node evenhead=head.next;
        while(even!=null&&even.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }odd.next=evenhead;
        return head;

    }
}
