package prac;

import java.util.Scanner;

public class BinaryTree {
   public  BinaryTree(){

    }
    static class Node{
       int value;
       Node left;
       Node right;
       public Node(int value){
           this.value=value;
           this.left=null;
           this.right=null;
       }
    }
    private Node root;
   public void populate(Scanner sc){
       System.out.println("Enter The root node");
       int val=sc.nextInt();
       root=new Node(val);
       populateRec(sc,root);
   }
   public void populateRec(Scanner sc,Node current){
       System.out.println("Do you Want To add the left child of"+current.value+"?");
       boolean addLeft=sc.nextBoolean();
       if(addLeft){
           System.out.println("Enter the Left Value of"+current.value);
           int val=sc.nextInt();
           current.left=new Node(val);
           populateRec(sc,current.left);
       }
       System.out.println("Do you want to add the right child of"+current.value+"?");
       boolean addRight=sc.nextBoolean();
       if(addRight){
           System.out.println("enter the Right child value of"+current.value);
           int val=sc.nextInt();
           current.right=new Node(val);
           populateRec(sc,current.right);
       }
   }
   public void preOrder(){
       preOrder(root);
       System.out.println();
   }
   public void preOrder(Node node){
       if(node==null){
           return;
       }
       System.out.print(node.value+" ");
       preOrder(node.left);
       preOrder(node.right);

   }

   public void inOrder(){
       inOrder(root);
       System.out.println();
   }
   public void inOrder(Node node){
       if(node==null){
           return;
       }
       inOrder(node.left);
       System.out.println(node.value);
       inOrder(node.right);

   }

   public void postOrder(){
       postOrder(root);
       System.out.println();
   }
   public void postOrder(Node node){
       if(node==null){
           return;
       }
       postOrder(node.left);
       postOrder(node.right);
       System.out.println(node.value);
   }
}
