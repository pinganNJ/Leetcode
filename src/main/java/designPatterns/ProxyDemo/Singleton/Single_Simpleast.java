package designPatterns.ProxyDemo.Singleton;

/**
 * 单例模式，最简单的那种
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-10 18:44
 */

public class Single_Simpleast {

    //单例模式不管怎么样，先把构造函数私有化
    private Single_Simpleast(){}
    //给一个引用
    private Single_Simpleast instance;

    public Single_Simpleast getInstance(){
        //这里是饿汉式，如果直接在上面new一下，就是懒汉式（其实我也没记住，感觉没什么大的意思）
        if(instance == null){
            instance = new Single_Simpleast();
        }
        return instance;
    }


}
