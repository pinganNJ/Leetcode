package leetcode;

/**
 * 2.两数相加
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 15:47
 */

//思路：从各位开始，如果相加超过10，就进位1，然后运用sum/10和sum%10算出哥哥部分的数
// 注意：对于链表的题目，最好一开始就把链表头缓存起来

public class Q0002_addTwoNumbers {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);

        //缓存各个链表的头节点
        ListNode p = l1, q = l2, cur = node;
        //进位符号，只能是0或者1
        int flag = 0;

        //开始循环
        while (p != null || q != null) {
            //这里注意，如果其中一个链表已经到头了，以后的链表数值就设置为0
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            //这里是加上了进位的总和
            int sum = x + y + flag;


            //刷新进位符
            flag = sum / 10;

            //创建一个新的表节点
            cur.next = new ListNode(sum % 10);

            //刷新节点
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }


        //最后，如果进位是1，那么在最高位还要来个1
        if (flag != 0) {
            cur.next = new ListNode(flag);
        }


        return node.next;


    }


}


