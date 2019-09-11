package leetcode;

import java.util.Arrays;

/**
 * 889. 根据前序和后序遍历构造二叉树
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-11 10:16
 */

//思路：用迭代，和前序中序一样，先找到根节点在后序节点中的位置，然后分割后序和前序，分成左边和右边，然后迭代
public class Q0889_constructFromPrePost {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        if(pre == null || pre.length == 0 || pre.length != post.length){
            return null;
        }
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }

        TreeNode root = new TreeNode(pre[0]);
        int i ;
        for ( i = 0; i < post.length; i++) {
            if(post[i] == pre[1]){
                break;
            }
        }
        int len = post.length;

        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,i+2),
                Arrays.copyOfRange(post,0,i+1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,i+2,len),
                Arrays.copyOfRange(post,i+1,len - 1));

        return root;

    }
}
