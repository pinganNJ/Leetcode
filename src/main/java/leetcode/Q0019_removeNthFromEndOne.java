package leetcode;

import java.awt.dnd.DnDConstants;

/**
 * 19. 删除链表的倒数第N个节点：一次遍历法
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-13 14:39
 */

public class Q0019_removeNthFromEndOne {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //双指针，fist先走n+1步，然后一起走，直到first为null，此时，second指在倒数第n个节点的前一个节点
    //这里还是用到了虚拟节点，放在head前面
    //也就是说两个指针之间，一直是想差n个节点，当first为null的时候（最后一个节点的后面），second正好在倒数第n个节点前一个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode DNode = new ListNode(0);
        DNode.next = head;
        ListNode cur = DNode;
        int step = n + 1;
        //first先走n+1步
        while (step > 0) {
            step--;
            cur = cur.next;
        }
        ListNode cur2 = DNode;
        //两个指针一起走，直到first为空
        while (cur != null) {
            cur = cur.next;
            cur2 = cur2.next;
        }

        cur2.next = cur2.next.next;

        return DNode.next;

    }
}
