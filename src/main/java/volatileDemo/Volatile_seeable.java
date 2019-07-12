package volatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * 测试volatile的不保证可见性
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-12 15:46
 */

public class Volatile_seeable {

    public static class MyData {

        private  int  num = 10;
        //private volatile  int  num = 10;


        private void changeData() {
            this.num = 100;
        }
    }

    public static void main(String[] args) {

        MyData myData = new MyData();
        new Thread(()->{

            //这里的TimeUnit就是对Thread.sleep的封装
            //必须要在这里sleep一下让主线程先跑，不然主线程直接跑完了
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.changeData();
        }).start();

        //如果不加volatile，上面的thread线程改变了num是对主线程不可见的
        while (myData.num == 10){

        }

        //加了volatile就能运行到这里了，不然会一直在上面循环着
        System.out.println("hah");


    }


}





