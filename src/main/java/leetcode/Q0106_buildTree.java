package leetcode;

import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-11 14:46
 */

public class Q0106_buildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len = postorder.length;

        TreeNode root = new TreeNode(postorder[len - 1]);

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[len - 1]) {
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, len), Arrays.copyOfRange(postorder, i, len - 1));


        return root;

    }
}