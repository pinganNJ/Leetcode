package juc;

/**
 * 手写一个死锁
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-16 11:26
 */

public class DeadLockByHand {

    public static void main(String[] args) {
        //这里写两个string类，供下面的synchronized用
        String lockA = "AAA";
        String lockB = "BBB";

        //拿到A锁，不释放，还想要B锁
        new Thread(()->{
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName() +  "持有" + lockA +"他想要" + lockB);
                synchronized (lockB){
                    System.out.println(Thread.currentThread().getName()  +  "拿到" + lockB  + "了");
                }

            }
        }).start();
        //拿到B锁，不释放，还想要A锁
        new Thread(()->{
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() +  "持有" + lockB +"他想要" + lockA);
                synchronized (lockA){
                    System.out.println(Thread.currentThread().getName() +  "拿到" + lockA  + "了");
                }
            }
        }).start();
    }
}


/*
输出：

Thread-0持有AAA他想要BBB
Thread-1持有BBB他想要AAA

        */
