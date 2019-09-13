package leetcode;

import designPatterns.builder.BuilderPat;

/**
 * 148. 排序链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-11 16:35
 */


//思路：就是通过快慢指针（这里要记住快慢指针的做法），然后归并排序的思路，左右递归排序，然后merge两边
public class Q0148_sortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode cur = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(cur);

        ListNode res = new ListNode(-1);
        ListNode result = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }

            res = res.next;
        }

        res.next = left == null ? right : left;

        return result.next;
    }
}















