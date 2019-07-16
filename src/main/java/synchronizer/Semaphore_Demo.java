package synchronizer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore：海底捞等桌位
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-15 21:35
 */

public class Semaphore_Demo {

    //初始化三个可处理线程的岗位（海底捞预设三个座位）
    public static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    //这里先申请一个线程处理位（申请一个座位）
                    semaphore.acquire();
                    System.out.println("第" + num + "号客人吃饭了");
                    System.out.println("第" + num + "号客人吃完了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //将这个线程处理位释放掉，
                    semaphore.release();
                }
            }).start();

        }
    }
}


/*

第3号客人吃饭了
第1号客人吃饭了
第2号客人吃饭了

======= 一共有三个座位，先进来三个 =====
第3号客人吃完了
第1号客人吃完了
第2号客人吃完了
第5号客人吃饭了
第4号客人吃饭了
第4号客人吃完了
第7号客人吃饭了
第7号客人吃完了
第6号客人吃饭了
第5号客人吃完了
第6号客人吃完了

            */
