package leetcode;

/**
 * 21. 合并两个有序链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 10:51
 */

/*
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4*/

//思路：其实就是归并的思想，但是比数组那个简单很多（不要想复杂了），就每次比较两个链表的数值，哪个小就放哪个，
// 最后如果哪个表空了，直接就接上剩下了另一个表


public class Q0021_mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;

        //两个表都不空，依次比较两个表的数值
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }


        //有一个表空了
        cur.next = l1 == null ? l2 : l1;

        return head.next;


    }
}    }