package volatileDemo;

import java.lang.reflect.GenericArrayType;

/**
 * 单例模式，最简单的那种
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-12 21:36
 */

public class Singleton {


    private static Singleton instance = null;

    //单例模式最关键的就是把构造函数私有化
    private Singleton(){}

    //因为构造函数私有化了之后，这里可以用static关键字修饰，直接可以类名引用
    public static Singleton getInstance(){

        if(instance == null){
            instance = new Singleton();
        }

        return instance;

    }

    //做个小测试，输出true
    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("!：" + (s1 == s2));

    }

}
