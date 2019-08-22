package leetcode;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Stack;

/**
 * 538.把二叉搜索树转换为累加树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-22 10:57
 */

//思路：和中序遍历二叉树差不多，只不过这里是先压右节点，然后弹出来的时候用一个变量preValue存前面的值，然后这个节点换成preValue

public class Q0538_convertBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        int preValue = 0;

        //先压右节点，然后压左节点
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node.val += preValue;
                preValue = node.val;

                node = node.left;
            }
        }
        return root;
    }
}
