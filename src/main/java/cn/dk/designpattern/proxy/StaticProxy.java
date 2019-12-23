package cn.dk.designpattern.proxy;

/**
 * 静态代理类，在委托类方法的前后添加了其他与委托类业务无关的操作
 * 缺点是针对每个接口都需要至少写一个这样的代理类
 */
public class StaticProxy implements ConsumerCount{
    private ConsumerCountImpl consumerCount;

    public StaticProxy(ConsumerCountImpl consumerCount) {
        this.consumerCount = consumerCount;
    }

    @Override
    public void queryCount() {
        System.out.println("代理查询处理之前");
        consumerCount.queryCount();
        System.out.println("代理查询处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("代理修改处理之前");
        consumerCount.updateCount();
        System.out.println("代理修改处理之后");
    }
}
