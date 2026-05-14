package CAT2;

import java.util.*;
// Tree Node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Tuple to store node + coordinates
class Tuple {
    TreeNode node;
    int col; // column (x)
    int lev; // level (y)

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.col = row;
        this.lev = col;
    }
}

public class VerticalOrderTrav {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        // column → row → minHeap
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        // BFS
        while (!q.isEmpty()) {
            Tuple t = q.poll();

            TreeNode node = t.node;
            int x = t.col; // column
            int y = t.lev; // level

            //  Create column if not exists
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            //  Create a level if not exists
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            //  Insert value
            map.get(x).get(y).offer(node.val);

            // Left child
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Right child
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Build result
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> s : map.values()) {
            result.add(new ArrayList<>());

            for (PriorityQueue<Integer> nodes : s.values()) {
                while (!nodes.isEmpty()) {
                    result.get(result.size() - 1).add(nodes.poll());
                }
            }
        }

        return result;
    }

    // Test
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);
    }
}