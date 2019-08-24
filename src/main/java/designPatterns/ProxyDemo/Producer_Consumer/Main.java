package designPatterns.ProxyDemo.Producer_Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @AUTHOR PizAn
 * @CREAET 2019-08-23 14:53
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //默认阻塞队列大小为10
        ProdConsWithBlokingQueue queue = new ProdConsWithBlokingQueue(new ArrayBlockingQueue<String>(10));

        //开两个线程，一个生产，一个消费
        new Thread(() -> {
            try {
                queue.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "product").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {

                queue.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();


        TimeUnit.SECONDS.sleep(6);
        System.out.println("拉闸");
        queue.stop();
    }
}

/*

输出：
        product成功生产了：1
        consumer消费成功：1
        product成功生产了：2
        consumer消费成功：2
        product成功生产了：3
        consumer消费成功：3
        product成功生产了：4
        consumer消费成功：4
        product成功生产了：5
        consumer消费成功：5
        product成功生产了：6
        consumer消费成功：6
        product成功生产了：7
        拉闸
*/
