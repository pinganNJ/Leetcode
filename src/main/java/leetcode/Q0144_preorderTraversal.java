package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144.二叉树的前序遍历
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-09 14:19
 */

public class Q0144_preorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代
    public List<Integer> preorderTraversal(TreeNode root) {


        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();

        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));

        return list;


    }

    //递归版本:就是用一个栈，先压右节点，再压左节点，每次弹一个
    public List<Integer> preorderDigui(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }
}
