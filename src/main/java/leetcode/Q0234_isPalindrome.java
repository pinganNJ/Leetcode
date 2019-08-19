package leetcode;

import java.nio.file.FileAlreadyExistsException;

/**
 * 234.回文链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 14:33
 */

//思路：写的有点乱，特别是在某些地方用到了节点缓存（不知道要不要用，对于链表习惯性地保存了节点）
//具体步骤就是：快慢指针拿到中间节点，后半部分反转链表，然后逐个比较确定结果，最好再把后面的链表反转回来（不能经过这个判断的方法把人家链表也给改了==）
//具体解析请看：https://blog.csdn.net/weixin_39782583/article/details/87652017
public class Q0234_isPalindrome {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }


        ListNode fast = head;
        ListNode slow = head;


        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        //反转后面的链表
        ListNode preNode1 = null;
        ListNode nextNode1 = null;
        ListNode slowCopy = slow;

        while (slowCopy != null) {
            nextNode1 = slowCopy.next;
            slowCopy.next = preNode1;
            preNode1 = slowCopy;
            slowCopy = nextNode1;
        }

        //后面的头节点是preNode1
        ListNode preNode1Copy = preNode1;
        ListNode head1 = head;

        boolean result = true;

        //前后部分链表逐个比较，确定结果
        while (preNode1 != null && head1 != null) {
            if (preNode1.val != head1.val) {
                result = false;
            }

            preNode1 = preNode1.next;
            head1 = head1.next;
        }


        //将后半部分链表反转回来
        ListNode preNode2 = null;
        ListNode nextNode2 = null;

        while (preNode1Copy != null) {
            nextNode2 = preNode1Copy.next;
            preNode1Copy.next = preNode2;
            preNode2 = preNode1Copy;
            preNode1Copy = nextNode2;
        }

        return result;


    }
}