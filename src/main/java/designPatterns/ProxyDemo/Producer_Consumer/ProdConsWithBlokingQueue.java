package designPatterns.ProxyDemo.Producer_Consumer;

import javax.xml.stream.FactoryConfigurationError;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模式-阻塞队列版
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-23 14:34
 */

public class ProdConsWithBlokingQueue {

    private volatile boolean flag = true;

    private BlockingQueue<String> blockingQueue;

    private AtomicInteger atomicInteger = new AtomicInteger();

    //这个地方的blockingQueue是接口，在主函数中可以自己定义其实现类，比如ArrayBlockingQueue
    public ProdConsWithBlokingQueue(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    //生产者：就是往阻塞队列里面放数据，这里放的是自增的atonicInteger
    public void producer() throws InterruptedException {

        String data = null;
        boolean res;

        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            res = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (res) {
                System.out.println(Thread.currentThread().getName() + "成功生产了：" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产失败");
            }
            //生产完停一秒，这样好看一点，如果你不加，那么生产者就会一下子生产10个，然后消费者消费一个，生产者再生产一个
            TimeUnit.SECONDS.sleep(1);
        }

    }


    public void consumer() throws InterruptedException {

        String data = null;

        while (flag) {
            //两秒钟内没有拿到数据，就报错
            data = blockingQueue.poll(2, TimeUnit.SECONDS);

            if (data == null || data.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "消费失败");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "消费成功：" + data);
            //挺一秒，等待生产者生产数据
            TimeUnit.SECONDS.sleep(1);
        }
    }


    //停止：直接将flag设置为false
    public void stop() {
        flag = false;
    }


}












