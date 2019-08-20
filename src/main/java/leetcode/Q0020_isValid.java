package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 10:05
 */

//思路：就是用一个栈，如果是作括号就压栈，如果是右括号就把栈顶元素拿出来匹配，如何判断前后括号？用map存一下

public class Q0020_isValid {

    private HashMap<Character, Character> map;

    public Q0020_isValid() {
        map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();


        char[] chars = s.toCharArray();

        //遍历这个字符串
        for (int i = 0; i < chars.length; i++) {

            //如果是左边的括号，直接存进map
            if (map.containsKey(chars[i])) {
                stack.push(chars[i]);
            } else {

                //如果是右边的括号，和栈顶元素肯定是匹配的
                //在这里如果栈已经空了或者从栈顶拿的元素为键从map获取的括号不等于我们拿到的字符，就返回false
                if (stack.isEmpty() || map.get(stack.pop()) != chars[i]) {
                    return false;
                }

            }

        }

        if (!stack.isEmpty()) {
            return false;
        }


        return true;

    }
}
