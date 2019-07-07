import java.util.concurrent.*;

/**
 * 手写一个线程池
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-07 12:30
 */

public class ThreadPoolByHand {

    public static void main(String[] args) {

        //不用Excutors自带的几个（三个）线程池，自己写，因为那些设计不合理
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                2, //银行办理业务的人数
                5, //最大的可加班的人数
                3L, //如果这么长时间接不到活，加班的人就走了
                TimeUnit.SECONDS, //时间单位
                new LinkedBlockingDeque<>(2), //阻塞队列，就是排队等待的地方，超过了一定的人数（线程数），会加班（扩容），但不会超过maximumPoolSize
                Executors.defaultThreadFactory(), //一些默认的东西，比如员工制服，公司logo
                new ThreadPoolExecutor.DiscardOldestPolicy()); //加班的人来了，阻塞队列也满了，来不及处理了，拒绝的策略

        //模拟创建10个线程
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "完成了任务");
            });
        }


    }


}
