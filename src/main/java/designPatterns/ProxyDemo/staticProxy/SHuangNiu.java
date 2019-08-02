package designPatterns.ProxyDemo.staticProxy;

/**
 * 黄牛，代理类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-02 9:30
 */

public class HuangNiu implements Work {

    private Work work;

    //构造函数里面传入接口，接口可以实现方法
    public HuangNiu() {
        work = new Seller();
    }

    @Override
    public void sell() {
        work.sell();
        //黄牛是代理类，增加的方法
        otherMethord();
    }

    private void otherMethord() {
        System.out.println("我是黄牛，我实现了售货员的功能并且，嘿嘿，不用排队哦~");
    }
}
