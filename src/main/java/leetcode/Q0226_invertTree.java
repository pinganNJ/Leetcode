package leetcode;

/**
 * 226. 翻转二叉树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 16:32
 */


//思路：还是用递归（发现树里面基本上很多都是用的递归），只要把根节点和其左右节点的情况分析一下就行了

public class Q0226_invertTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {


        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;

    }
}