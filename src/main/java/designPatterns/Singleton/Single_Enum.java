package designPatterns.ProxyDemo.Singleton;

/**
 * 单例模式，枚举模式
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-10 18:48
 */

public enum  Single_Enum {

    //枚举模式，因为枚举本来就是单例的，所以这也算是一个实现方法
    INSTACE("PIZAN",23);

    private String name;
    private int age;

    private Single_Enum(String name,int age){
        this.name = name;
        this.age = age;
    }

    //other method...


}
