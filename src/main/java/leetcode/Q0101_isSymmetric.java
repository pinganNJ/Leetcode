package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 101.对称二叉树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 16:49
 */

//思路：发现还是用递归好，这里一开始没想到是从左右子节点开始遍历的，也就是说重新开一个方法，这个要借鉴

public class Q0101_isSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {

        //如果两个节点都是null，返回true
        if (t1 == null && t2 == null) {
            return true;
        }

        //如果两个节点有一个为null，返回false
        if (t1 == null || t2 == null) {
            return false;
        }

        //镜像的条件，数值相等+左右节点镜像
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);


    }
}

//我先做个自己想的，中序遍历这个二叉树，然后的到的数组/list是前后对称的-----这个思路是错的，22122，想一想，这个数可以成为很多树，但是不对称
   /* public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root.left != null) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                root = cur.right;
            }
        }
        int lenth = list.size();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(lenth - i)) {
                return false;
            }
        }

        return true;
    }*/




