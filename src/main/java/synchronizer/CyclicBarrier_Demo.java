package synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier：集齐龙珠，召唤神龙
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-15 21:34
 */

public class CyclicBarrier_Demo {


    //注意这里CyclicBarrier的构造函数，第一个时等待的线程个数（龙珠个数），第二个是等待结束后的执行线程（召唤神龙）
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(7,new Thread(()->{
        System.out.println("集齐了七颗龙珠，召唤神龙~");
    }));

    public static void main(String[] args) {
        //来七个线程找龙珠，或者说，上面那个线程只等待七个线程的时间
        for (int i = 1; i <=7 ; i++) {
            final int num = i;
            new Thread(()->{
                System.out.println("第" + num + "个龙珠集齐了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}


/*
输出：

第1个龙珠集齐了
第4个龙珠集齐了
第5个龙珠集齐了
第6个龙珠集齐了
第2个龙珠集齐了
第3个龙珠集齐了
第7个龙珠集齐了
集齐了七颗龙珠，召唤神龙~

       */
