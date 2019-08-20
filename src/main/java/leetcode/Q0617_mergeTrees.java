package leetcode;

/**
 * 617.合并二叉树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 12:22
 */


//思路：递归（一次过），首先判断t1和t2会不会是空的，然后构造一个头节点，然后递归左右子节点

public class Q0617_mergeTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }


        //t1和t2都不是空的
        TreeNode node = new TreeNode(t1.val + t2.val);

        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;


    }
}
