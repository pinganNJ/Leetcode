package leetcode;

/**
 * 142.环形链表 II
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 17:04
 */


//思路：之前用快慢节点证明有环，这次用=找到这个入环点（快慢节点上稍加优化）

public class Q0142_detectCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { //说明有环，下面来求入环点，用另外一个指针从表头开始走，相遇的地方就是入环点
                ListNode cur = head;

                while (cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;

            }
        }

        return null;

    }
}


