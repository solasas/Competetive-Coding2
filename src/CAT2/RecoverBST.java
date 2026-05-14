package CAT2;

import java.util.*;



public class RecoverBST {

    public static void RecoverTree(Node root) {
        List<Integer> inorder = new ArrayList<>();

        // Step 1: store inorder
        inorderTraversal(root, inorder);

        // Step 2: sort
        Collections.sort(inorder);

        // Step 3: put values back
        fixTree(root, inorder, new int[]{0});
    }

    // Inorder traversal
    private static void inorderTraversal(Node root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    // Replace values using inorder again
    private static void fixTree(Node root, List<Integer> list, int[] index) {
        if (root == null) return;

        fixTree(root.left, list, index);

        root.val = list.get(index[0]++);

        fixTree(root.right, list, index);
    }

    public static void main(String[] args) {

    }
}