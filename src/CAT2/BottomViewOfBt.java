package CAT2;



import java.util.*;

// Node class


public class BottomViewOfBt {

    public static List<Integer> bottomView(Node root) {
        Queue<Pair> que = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        que.offer(new Pair(root, 0));

        while (!que.isEmpty()) {
            Pair p = que.poll();



                map.put(p.hd, p.node.val);


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

        List<Integer> result = bottomView(root);

        System.out.println("Bottom View:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}