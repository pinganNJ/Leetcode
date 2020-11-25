package leetcode;

/**
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 22:35
 */

public class Main {

    public static void main(String[] args) {

        String s = "cbacdcbc" ;
        Q0316_RemoveDuplicateLetters removeDup = new Q0316_RemoveDuplicateLetters();
        String s1 = removeDup.removeDuplicateLetters(s);
        System.out.println(s1);
    }
}
