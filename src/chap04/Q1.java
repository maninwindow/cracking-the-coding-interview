package chap04;

import static helpers.Printer.*;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined
 * to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
public class Q1 {
    public static boolean isBalanced(TreeNode n) {
        if (n == null) return true;
        return Math.abs(getHeight(n.left) - getHeight(n.right)) <= 1 &&
               isBalanced(n.left) &&
               isBalanced(n.right);
    }

    public static boolean isBalanced2(TreeNode n) {
        if (n == null) return true;
        if (Math.abs(getHeight(n.left) - getHeight(n.right)) > 1) return false;
        if (!isBalanced(n.left) || !isBalanced(n.right)) return false;
        return true;
    }

    public static boolean isBalanced3(TreeNode n) {
        return getHeightBalanced(n) != -1;
    }

    private static int getHeight(TreeNode n) {
        if (n == null) return 0;
        return 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    private static int getHeightBalanced(TreeNode n) {
        if (n == null) return 0;
        int leftHeight = getHeightBalanced(n.left);
        int rightHeight = getHeightBalanced(n.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        /*
         *     4
         *    / \
         *   1   5
         *  / \
         * 2   3
         */
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3), r = new TreeNode(4);
        n1.left = new TreeNode(2); n1.right = n2;
        r.left = n1; r.right = new TreeNode(5);
        print(isBalanced(r) + " ");
        print(isBalanced2(r) + " ");
        println(isBalanced3(r));
        /*
         *     4
         *    / \
         *   1   5
         *  / \
         * 2   3
         *      \
         *       6
         */
        n2.right = new TreeNode(6);
        print(isBalanced(r) + " ");
        print(isBalanced2(r) + " ");
        print(isBalanced3(r));
    }
}
