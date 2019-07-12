package volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用AtomicInteger解决volatile不保证原子性的问题
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-12 16:53
 */

public class volatileWithAtomicInteger {

    public static class MyData02 {

        //这里不加volatile保证可见性好像也没什么影响？
        private  AtomicInteger atomicInteger = new AtomicInteger(1);

        private void changeData() {
            atomicInteger.getAndAdd(1);
        }
    }

    public static void main(String[] args) {

        MyData02 myData = new MyData02();

        //这里用20个线程同时加1000次，因为volatile不保证原子性，所以这里会乱起来，都去修改共享内存里的i，
        // 就算加了volatile也不能解决这个问题
        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.changeData();
                }
            }).start();
        }
            //如果后台线程大于2(后台默认有一个main和GC线程)，就让线程继续执行,这里是保证上面的线程全部执行完
            while (Thread.activeCount() > 2) {
                Thread.yield();
            }

            System.out.println("num：" + myData.atomicInteger);
        }

    }

