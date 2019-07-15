package cn.dk.designpattern.proxy;

/**
 * 代理类和被代理类实现的接口
 */
public interface ConsumerCount {
    // 查看账户
    void queryCount();

    // 修改账户
    void updateCount();
}
