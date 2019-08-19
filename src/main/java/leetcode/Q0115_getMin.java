package leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 155.最小栈
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 11:37
 */

public class Q0115_getMin {

    private Stack<Integer> stack_L;
    private Stack<Integer> stack_R;

    /**
     * initialize your data structure here.
     */
    public Q0115_getMin() {

        stack_L = new Stack<>();
        stack_R = new Stack<>();
    }

    public void push(int x) {

        stack_L.push(x);

        if (stack_R.isEmpty()) {
            stack_R.push(x);
        } else if (x >= stack_R.peek()) {
            stack_R.push(stack_R.peek());
        } else {
            stack_R.push(x);
        }
    }


    public void pop() {
        if (stack_L.isEmpty()) {
            throw new EmptyStackException();
        }
        stack_L.pop();
        stack_R.pop();

    }
    public int top() {
        if (stack_L.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack_L.peek();
    }

    public int getMin() {
        if (stack_L.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack_R.peek();


    }
}
