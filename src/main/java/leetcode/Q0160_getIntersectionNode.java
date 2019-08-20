package leetcode;

/**
 * 160.相交链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 13:34
 */


//思路：其实这个题目是简单的，因为已经假定无环了，（有环还要分两种情况）
//无环的化就是看长短，长的先走差值，然后一起走，相遇点为橡胶点

public class Q0160_getIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        int a = 0;
        int b = 0;


        while (curA != null) {
            a++;
            curA = curA.next;
        }

        while (curB != null) {
            b++;
            curB = curB.next;
        }

        //如果两个链表的尾部节点都不相等，那么肯定不相交
        if (curA != curB) {
            return null;
        }

        //判断哪个是长的哪个是短的
        ListNode longHead = a > b ? headA : headB;
        ListNode shortHead = a > b ? headB : headA;

        //找出长短链表长度的差值
        int cha = Math.abs(a - b);

        //长链表先走差值步，然后一起走，相交点
        while (cha != 0) {
            longHead = longHead.next;
            cha--;
        }

        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }
}
