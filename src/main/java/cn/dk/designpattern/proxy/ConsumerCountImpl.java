package cn.dk.designpattern.proxy;

/**
 * 委托类，可用于和代理类进行比较
 */
public class ConsumerCountImpl implements ConsumerCount {
    @Override
    public void queryCount() {
        System.out.println("原类的查询账户方法");
    }

    @Override
    public void updateCount() {
        System.out.println("原类的修改账户方法");
    }
}
