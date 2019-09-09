package leetcode;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

/**
 * 94.二叉树中序遍历
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 18:14
 */


//思路：用栈

public class Q0094_inorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    //递归版本：先将左边全部压栈，然后弹栈，往右走
    public List<Integer> inorderDigui(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root); //注意这个地方不能先压栈

        while (!stack.isEmpty() || root != null) {//必须要有个root != null的判定
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}



