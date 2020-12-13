package leetcode;

/**
 * 844. 比较含退格的字符串
 *
 * @AUTHOR PizAn
 * @CREAET 2020-12-13 23:38
 */

public class Q0844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return change(S).equals(change(T));
    }
    public String change(String S){
        StringBuilder sb = new StringBuilder();
        for(Character c : S.toCharArray()){
            if(!c.equals('#')){
                sb.append(c);
            }else{
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}


