package designPatterns.ProxyDemo.dynamicProxy;

import designPatterns.ProxyDemo.staticProxy.Work;

/**
 * 静态代理类，被代理类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-02 9:26
 */

public class Seller implements Work {
    @Override
    public void sell() {
        System.out.println("这里是被代理类，我在售票");
    }
}
