package prac;

import java.util.*;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;

    }
}
class Pair{
    Node node;
    int hd;
    Pair(Node node,int hd){
        this.node=node;
        this.hd=hd;
    }
}
public class Topview {
    public static List<Integer> topview(Node root){
        Queue<Pair> que=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        que.offer(new Pair(root,0));

        while(!que.isEmpty()){
            Pair p=que.poll();

            if(!map.containsKey(p.hd)){
                map.put(p.hd, p.node.val);
            }
            if(p.node.left!=null){
                que.offer(new Pair(p.node.left,p.hd-1));

            }
            if(p.node.right!=null){
                que.offer(new Pair(p.node.right,p.hd+1));
            }
        }
        return new ArrayList<>(map.values());
    }
}
