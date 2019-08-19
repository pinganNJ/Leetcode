package leetcode;

/**
 * 141. 环形链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 16:53
 */


//思路：很简单，用快慢指针，如果二者相遇了，说明有环

public class Q0141_hasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        public boolean hasCycle(ListNode head) {

            if (head == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;


        }

    }
