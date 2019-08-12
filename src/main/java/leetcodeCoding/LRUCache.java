package leetcodeCoding;

import javax.management.NotificationEmitter;
import javax.transaction.xa.Xid;
import java.awt.dnd.DnDConstants;
import java.util.HashMap;

/**
 * 手写 LRU：双向链表 + hashmap
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-12 19:36
 */

public class LRUCache {

    //内部类，双向链表
    class DNode {
        int key;
        int value;
        DNode pre;
        DNode last;

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DNode> map;

    //双向链表的头和尾，这里更新的节点放在head一方
    DNode head;
    DNode tail;

    //当前节点数
    int size;
    //缓存大小
    int capacity;

    //初始化这个缓存
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DNode(0, 0);
        tail = new DNode(0, 0);

        head.pre = null;
        head.last = tail;
        tail.pre = head;
        tail.last = null;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        //通过map来看，如果不存在这个key，就返回-1；
        if (!map.containsKey(key)) {
            return -1;
        } else {
            DNode node = map.get(key);
            delete(key);
            addHead(key, node.value);
            return node.value;
        }
    }

    public void put(int key, int value) {
        //如果map中有这个节点，就相当于把这个节点放到队列头部去
        if (map.containsKey(key)) {
            delete(key);
            addHead(key, value);
        } else {
            addHead(key, value); //如果没有这个节点直接放在头部，容量的大小在addHead里面判断
        }
    }

    private void addHead(int key, int value) {

        //先创造一个node出来，然后放到头部去
        DNode node = new DNode(key, value);

        //拿到头节点的下一个节点
        DNode headLast = head.last;

        //把node嵌入到head和headLast之间
        head.last = node;
        node.pre = head;
        node.last = headLast;
        headLast.pre = node;

        map.put(key,node);

        size++;
        //如果超出了容量，将最后一个节点删掉
        if (size > capacity) {
            DNode tailPre = tail.pre;
            delete(tailPre.key);
        }

    }

    private void delete(int key) {

        //先获取当前的节点
        DNode node = map.get(key);

        //获得当前节点的前后节点，然后让他们链接起来
        DNode nodePre = node.pre;
        DNode nodeLast = node.last;

        nodePre.last = nodeLast;
        nodeLast.pre = nodePre;
        size--;
        map.remove(key);

    }
}
