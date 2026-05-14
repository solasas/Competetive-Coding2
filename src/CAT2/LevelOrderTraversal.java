package CAT2;

import java.util.*;


public class LevelOrderTraversal{
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static List<List<Integer>> levelOT(Node root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int lsize=qu.size();
            List<Integer> currentlevel=new ArrayList<>();
            for(int i=0;i<lsize;i++){
                Node current=qu.poll();
                currentlevel.add(current.val);
                if(current.left!=null){
                    qu.add(current.left);
                }
                if(current.right!=null){
                    qu.add(current.right);
                }

            }ans.add(currentlevel);
        }return ans;

    }

    public static List<Integer> leftView(Node root){
        List<Integer> leftview=new ArrayList<>();
        if(root==null) return leftview;

        List<List<Integer>> lot=levelOT(root);
        for(int i=0;i<lot.size();i++){
            leftview.add(lot.get(i).get(0));
        }
        return leftview;

    }
    public static   List<Integer> rightView(Node root){
        List<Integer> rightview=new ArrayList<>();
        if(root==null) return rightview;

        List<List<Integer>> lot=levelOT(root);
        for(int i=0;i<lot.size();i++){
            int size=lot.get(i).size();
            rightview.add(lot.get(i).get(size-1));
        }
        return rightview;
    }
    public static void main(String args[]){
        Node root=new Node(3);
        root.left=new Node(1);
        root.right=new Node(4);
        root.right.left=new Node(2);
        System.out.println(levelOT(root));
        System.out.println(leftView(root));
        System.out.println(rightView(root));
    }
}