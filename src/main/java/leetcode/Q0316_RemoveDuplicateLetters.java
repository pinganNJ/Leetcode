package leetcode;

import java.util.Stack;

/**
 * @Author PizAn
 * @Description Q0316_去除重复字母,且字典序最小
 * @Param
 * @return
 **/

public class Q0316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        //1、计算出s里面每个元素的个数
        //2、压栈，如果压得数比栈顶元素小，那么弹栈
        //3、如果元素只剩下一个了，就不弹了，如果数已经在栈里面了，也不压进去
        //4、全部弹出，然后翻转


        int[] count = new int[256];
        boolean[] isInStack = new boolean[256];

        Stack<Character> stack = new Stack<>();

        for (Character c1 : s.toCharArray()) {
            count[c1]++;
        }
        for (Character c2 : s.toCharArray()) {
            count[c2]--;
            if (isInStack[c2] == true) {
                continue;
            }
            while (!stack.isEmpty() && c2 < stack.peek()) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                isInStack[stack.pop()] = false;
            }
            stack.push(c2);
            isInStack[c2] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

