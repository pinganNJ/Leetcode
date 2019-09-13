package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 199.二叉树的俯视图
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-13 13:23
 */


//思路：其实也很简单，就是看左右子树，左边的如果节点如果有左子树，就放到队列里面（这里用栈来做），然后右边的直接放右节点
//这里中间的根节点要单独放到队列里面（也就是说左子树只有左节点可见，右子树只有右节点可见）
public class Q0199_Updowniew {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();


        TreeNode cur = root;


        Stack<TreeNode> stack = new Stack<>();

        while (cur.left != null) {
            stack.push(cur.left);
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }

        list.add(root.val);

        while (root.right != null) {
            list.add(root.right.val);
            root = root.right;
        }

        return list;
    }

}