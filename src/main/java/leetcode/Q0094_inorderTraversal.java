package leetcode;

import java.util.ArrayList;
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

    public List<Integer> inorderTraversal(TreeNode root) {


        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        //将左边的压到栈中，然后弹栈的时候往右走
        while (!stack.isEmpty() || root != null) {
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



