package designPatterns.ProxyDemo.staticProxy;

/**
 * 静态代理类，被代理类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-02 9:26
 */

public class SSeller implements SWork {
    @Override
    public void sell() {
        System.out.println("这里是被代理类，我在售票");
    }
}
