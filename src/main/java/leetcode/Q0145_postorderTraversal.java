package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145.二叉树的后序遍历
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-09 22:19
 */


//思路：后序遍历，左右中 --> 中右左（就是前序遍历先压左再压右）-->反转：左右中
public class Q0145_postorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

