package leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 17:56
 */


//思路：因为之前已经做过了中序遍历，而搜索树就是前<中<后，只要在打印节点的那个地方判断一下是不是大于前面的节点就行了
public class Q0098_isValidBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

        //ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        //妈蛋服了，这里的Double.MIN_VALUE不是Integer那种，而是无限接近于0的数
        //特么为什么这里比较数字要用到Double啊，平时不都是Integer么！！！
        double pre = -Double.MAX_VALUE;
        //Double.MIN_VALUE

        //将左边的压到栈中，然后弹栈的时候往右走
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= pre) {
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return true;


    }
}
