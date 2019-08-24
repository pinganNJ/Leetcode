package designPatterns.ProxyDemo.staticProxy;

import java.lang.reflect.Proxy;

/**
 * 黄牛，代理类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-02 9:30
 */

public class SHuangNiu implements SWork {

    private SWork work;

    //构造函数里面传入接口，接口可以实现方法
    public SHuangNiu() {
        work = new SSeller();
    }

    @Override
    public void sell() {
        work.sell();
        //黄牛是代理类，增加的方法
        otherMethord();
    }



    private void otherMethord() {
        System.out.println("我是静态黄牛，我实现了售货员的功能并且，嘿嘿，不用排队哦~");
    }
}
