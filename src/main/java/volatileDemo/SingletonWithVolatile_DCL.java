package volatileDemo;

/**
 * 单例模式，应用volatile禁止指令重排和Synchonized双重锁检测
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-12 21:48
 */

public class SingletonWithVolatile_DCL {

    //这里用volatile 禁止指令重排
    private static volatile SingletonWithVolatile_DCL instance = null;

    private SingletonWithVolatile_DCL() {
    }

    public static SingletonWithVolatile_DCL getInstance() {
        if (instance == null) {

            //DCL:Double Check Lock 双重锁检测机制，进保险库之前检查一下门闩，进去之后再检查一下
            synchronized (SingletonWithVolatile_DCL.class) {

                if (instance == null) {
                    instance = new SingletonWithVolatile_DCL();
                }
            }
        }
        return instance;
    }
}
