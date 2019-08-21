package leetcode;

import javax.print.DocFlavor;
import javax.swing.*;

/**
 * 543.二叉树的直径
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-21 17:18
 */


//思路：用迭代，直径 = 左边子树的高度+右边子树的高度+根节点
//迭代的设计：设计了一个外在的max，在迭代中就是已经算出来了，应该说是迭代到最外面的时候

public class Q0543_diameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return max;

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);

        //这里不需要再l+r+1了，因为l和r总共加了两次1，就把头节点加进去了
        max = Math.max(l + r, max);

        return Math.max(l, r) + 1;
    }
}







