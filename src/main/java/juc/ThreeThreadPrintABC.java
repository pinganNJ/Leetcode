package juc;

import java.awt.*;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印ABC
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-21 12:37
 */

public class ThreeThreadPrintABC {

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private int flagNum = 1;

    //这里的condition就是syn里面的wait/signal，这里比较好理解，为每个操作函数加锁，然后用一个标志位结合condition来区分函数的执行顺序
    public void printA() {
        try {
            lock.lock();
            //如果标志位不一样，将这个函数锁起来
            while (flagNum != 1) {
                c1.await();
            }

            System.out.println("A");
            flagNum = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    //打印B
    public void printB() {
        try {
            lock.lock();

            while (flagNum != 2) {
                c2.await();
            }

            System.out.println("B");
            flagNum = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    //打印C
    public void printC() {
        try {
            lock.lock();

            while (flagNum != 3) {
                c3.await();
            }

            System.out.println("C");
            flagNum = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
