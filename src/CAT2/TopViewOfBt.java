package CAT2;

import java.util.*;

// Node class
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Pair class (node + horizontal distance)
class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfBt {

    public static List<Integer> topView(Node root) {
        Queue<Pair> que = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        que.offer(new Pair(root, 0));

        while (!que.isEmpty()) {
            Pair p = que.poll();

            // store only FIRST node at each HD
            if (!map.containsKey(p.hd)) {
                map.put(p.hd, p.node.val);
            }

            //for bottom view comment the above if condition and use below.
//            map.put(p.hd, p.node.val);

            if (p.node.left != null) {
                que.offer(new Pair(p.node.left, p.hd - 1));
            }

            if (p.node.right != null) {
                que.offer(new Pair(p.node.right, p.hd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {



        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        List<Integer> result = topView(root);

        System.out.println("Top View:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}