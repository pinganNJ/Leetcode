package leetcodeCoding;

import org.w3c.dom.Node;

/**
 * 反转单链表
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-21 21:42
 */

public class ReverseNode {

    public class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }


    //遍历版本
    public Node reverseNodeTraversing(Node node) {

        Node preNode = null;
        Node nextNode = null;

        while (node != null) {
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return preNode;

    }


    //递归版本
    public Node reverseNodeRecursive(Node node) {

       if (node == null || node.next == null){
           return  node;
       }

       Node headNode = reverseNodeRecursive(node.next);
       node.next.next = node;
       node.next = null;

       return headNode;
    }

}
