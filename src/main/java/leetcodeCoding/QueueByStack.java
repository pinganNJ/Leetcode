package leetcodeCoding;

import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈模拟队列
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-21 21:20
 */

public class QueueByStack {
    //初始化两个栈，就能变成FIFO
    private Stack<Integer> sLeft ;
    private Stack<Integer> sRight ;


    public QueueByStack(){
        sLeft = new Stack<Integer>();
        sRight = new Stack<Integer>();
    }
    //进队列
    public void push(Integer i){
        sLeft.push(i);
    }

    //出队列
    public Integer pop(){
        if(sLeft.isEmpty() && sRight.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The queue is empty!");
        }

        //这是一步“倒”的动作，首先要右栈是空的，然后将左边的栈里面的元素一次性全部倒到右边
        if (sRight.isEmpty()){
            while (!sLeft.isEmpty())
            sRight.add(sLeft.pop());

        }
        return sRight.pop();
    }
    //获得队列顶点
    public Integer peek(){
        if(sLeft.isEmpty() && sRight.isEmpty()){
            throw new EmptyStackException();
        }
        while (sRight.isEmpty()){

            while (!sLeft.isEmpty())
                sRight.add(sLeft.pop());
        }
        return sRight.peek();
    }
}
