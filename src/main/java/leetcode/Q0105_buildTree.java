package leetcode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-10 22:43
 */

public class Q0105_buildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        if (preorder.length != inorder.length) {
            return null;
        }
        if (preorder == null || preorder.length == 0)//空树 则直接返回
        {
            return null;
        }


        TreeNode firstNode = new TreeNode(preorder[0]);//注意，这类要在前面判断以下preorder[0]是否为0
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }
        int len = preorder.length;

        firstNode.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                Arrays.copyOfRange(inorder, 0, i));
        firstNode.right = buildTree(Arrays.copyOfRange(preorder, i + 1, len),
                Arrays.copyOfRange(inorder, i + 1, len));

        return firstNode;
    }
}
