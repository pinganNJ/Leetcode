package designPatterns.ProxyDemo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 黄牛，代理类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-02 9:30
 */

public class DHuangNiu implements InvocationHandler {

    private Object object;

    public DHuangNiu(Object object){
        this.object = object;
    }




    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        Object result = method.invoke(object, args);

        addMethod();
        return result;
    }

    private void addMethod() {
        System.out.println("我是动态黄牛，我实现了售货员的功能并且，嘿嘿，不用排队哦~");
    }


    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);

    }
}


