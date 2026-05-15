package prac;

import java.util.Scanner;

public class SegregateEO {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void addFirst(int val){
        Node newnode=new Node(val);

        newnode.next=head;
        head=newnode;
    }
    public static Node segregate(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node even=head.next;
        Node odd=head;
        Node evenHead=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        odd.next=evenHead;

        return head;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            if(n==-1){
                break;
            }
            addFirst(n);

        }
        segregate(head);
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
}
