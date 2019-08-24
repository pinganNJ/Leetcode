package designPatterns.ProxyDemo.Singleton;

/**
 * 单例模式，静态内部类模式
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-10 18:47
 */

public class Single_staticClass {

    //私有化构造函数
    private Single_staticClass() {
    }

    //这里用个静态类包起来，然后在下面引用
    private static class InstanceGet {
        private static Single_staticClass instance = new Single_staticClass();
    }

    public static Single_staticClass getInstance() {
        return InstanceGet.instance;
    }
}
