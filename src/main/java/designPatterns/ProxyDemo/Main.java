package designPatterns.ProxyDemo;

import designPatterns.ProxyDemo.dynamicProxy.DHuangNiu;
import designPatterns.ProxyDemo.dynamicProxy.DSeller;
import designPatterns.ProxyDemo.dynamicProxy.DWork;
import designPatterns.ProxyDemo.staticProxy.SHuangNiu;
import designPatterns.ProxyDemo.staticProxy.SSeller;
import designPatterns.ProxyDemo.staticProxy.SWork;

import java.lang.reflect.Proxy;

/**
 * 测试类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-01 22:40
 */

public class Main {
    public static void main(String[] args) {

        SHuangNiu sHuangNiu = new SHuangNiu();
        sHuangNiu.sell();

        System.out.println("================================");

        //动态黄牛里面没有写死，只是构造函数里面传进一个被代理对象
        SWork sseller = new SSeller();
        DHuangNiu dHuangNiu = new DHuangNiu(sseller);
        //这里是创建一个代理，然后返回一个被代理对象的实例
        SWork s = dHuangNiu.getProxy();

        s.sell();

    }


}

/*
输出：

        这里是被代理类，我在售票
        我是静态黄牛，我实现了售货员的功能并且，嘿嘿，不用排队哦~
        ================================
        这里是被代理类，我在售票
        我是动态黄牛，我实现了售货员的功能并且，嘿嘿，不用排队哦~
        */
