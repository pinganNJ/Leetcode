package juc;

/**
 * 测试循环打印ABC的主函数
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-21 12:55
 */

public class ThreeThreadPrintABCMain {

    public static void main(String[] args) {
        ThreeThreadPrintABC printABC = new ThreeThreadPrintABC();
        int i = 10;

        while (i != 0){
            new Thread(()->{
                printABC.printA();
            }).start();

            new Thread(()->{
                printABC.printB();
            }).start();

            new Thread(()->{
                printABC.printC();
            }).start();

            i--;
        }
    }
}


/*
输出：
        A
        B
        C
        A
        B
        C
        A
        B
        C
        A
        B
        C
。。。*/
