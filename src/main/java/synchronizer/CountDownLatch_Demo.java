package synchronizer;

import java.util.SortedMap;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch ：班长关门
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-15 21:33
 */

public class CountDownLatch_Demo {

    //先初始化7个名额
    public static CountDownLatch countDownLatch = new CountDownLatch(7);

    public static void main(String[] args) throws InterruptedException {
        //来七个线程（学生）消费这个名额
        for (int i = 1; i <= 7; i++) {
            final int index = i;
            new Thread(() -> {
                StudentEnum studentEnum = StudentEnum.getByNum(index);
                System.out.println(studentEnum.getName() + "同学走了~");

                //每次线程执行完，记录一下
                countDownLatch.countDown();
            }).start();

        }

        //我们最后要等待的线程，这里是主线程
        countDownLatch.await();
        //countDownLatch等待结束，主线程执行
        System.out.println("人都走了，克里斯关下门！");


    }


}


