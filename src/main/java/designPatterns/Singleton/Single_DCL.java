package designPatterns.ProxyDemo.Singleton;

/**
 * 单例模式，Dounle Check Lock
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-10 18:45
 */

public class Single_DCL {

    //单例模式不管怎么样，先把构造函数私有化
    private Single_DCL() {
    }

    //给一个引用,这里用volatile修饰，保证可见性
    private volatile Single_DCL instance;

    public Single_DCL getInstance() {
        //这里是饿汉式，如果直接在上面new一下，就是懒汉式（其实我也没记住，感觉没什么大的意思）
        if (instance == null) {
            //之所以叫Dounle Check Lock，就像去了卫生间，锁起来然后再检查一遍
            synchronized (Single_DCL.class) {
                if (instance == null) {
                    instance = new Single_DCL();
                }
            }
        }
        return instance;
    }

}
