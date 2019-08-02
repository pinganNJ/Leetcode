package designPatterns.dynamicProxy;

import designPatterns.proxy.staticProxy.Seller;

/**
 * 测试类
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-01 22:40
 */

public class Main {
    public static void main(String[] args) {
        Seller seller = new Seller();

        HuangNiu huangNiu = new HuangNiu(seller);
        huangNiu.sell();
    }


}
