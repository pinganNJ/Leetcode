package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图/左视图
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-13 13:23
 */


//思路：其实就是层次遍历，然后每次取每一层最右边的数
public class Q0199_rightSideView {
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
        LinkedList<TreeNode> list = new LinkedList<>(); //每次放一层接待你的list
        ArrayList<Integer> result = new ArrayList<>(); //最后存放结果的list


        list.add(root);
        result.add(root.val);

        while (!list.isEmpty()) {
            int size = list.size(); //注意：这个地方list的size一定要先计算出来，不要放到下面的循环里面！，不然会出现并发修改异常
            for (int i = 0; i < size; i++) {
                TreeNode cur = list.poll(); //弹出来
                if (cur.left != null) {
                    list.add(cur.left);
                }
                if (cur.right != null) {
                    list.add(cur.right);
                }
            }
            if(!list.isEmpty()){
                result.add(list.peekLast().val);//链表尾部，就是从右边看
                //result.add(list.peekFirst().val);//链表头部，就是从左边看
            }
        }
        return result;
    }
}