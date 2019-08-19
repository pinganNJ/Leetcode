package leetcode;

/**
 * 206.反转链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 15:02
 */

public class Q0206_reverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //迭代
    public ListNode reverseList(ListNode head) {

        //这里搞两个临时节点，前向和后向节点
        ListNode nextNode = null;
        ListNode preNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        //注意这里是preNode，不是head，因为head已经是null，跳出循环了
        return preNode;
    }

    //递归
    public ListNode reverseListRrverse(ListNode head) {
        //递归结束条件
        if(head == null || head.next == null){
            return head;
        }

        ListNode curHead = reverseListRrverse(head.next);

        head.next.next = head;
        head.next = null;

        return curHead;



    }



}