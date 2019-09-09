package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-09 11:53
 */

public class Q0102_levelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = treeNodes.size(); //注意，这个地方是直接算的当前的size，这样就能一批一批地做了
            for (int i = 0; i < size; i++) {
                TreeNode current = treeNodes.poll();
                list.add(current.val);
                if (current.left != null) treeNodes.add(current.left);
                if (current.right != null) treeNodes.add(current.right);
            }

            result.add(list);

        }
        return result;


    }
}











