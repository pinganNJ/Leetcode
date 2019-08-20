package leetcode;

/**
 * 104.二叉树的最大深度
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 13:27
 */


//思路：（简单地一比，秒做出来），就是用递归，找到左右子节点的深度最大的那个，然后递归的跳出是在节点为null的时候

public class Q0104_maxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {

        //节点为null的时候跳出
        if(root == null){
            return 0;
        }

        //找到左右子树最深的那个，返回
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }
}