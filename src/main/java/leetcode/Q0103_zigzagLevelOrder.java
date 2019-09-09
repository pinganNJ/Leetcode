package leetcode;

import java.util.*;

/**
 * 103.二叉树的锯齿形层次遍历
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-09 13:58
 */

//思路：其实是102题层次遍历的加了一点东西，就是在将每层的list装入到result的时候考虑是不是要反转一下

public class Q0103_zigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        boolean flag = false;
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size(); //拿到现在linkedlist中节点的数量，然后一次装这么多，这样就有层次了
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = treeNodes.poll();
                list.add(cur.val);
                if (cur.left != null) treeNodes.add(cur.left);
                if (cur.right != null) treeNodes.add(cur.right);
            }
            if (flag == true) {
                Collections.reverse(list);
            }
            result.add(list);
            flag = !flag;
        }
        return result;


    }
}
