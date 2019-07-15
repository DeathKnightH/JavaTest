package cn.dk.designpattern.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumerCountTest {
    @Test
    public void staticProxyTest(){
        ConsumerCountImpl consumerCount = new ConsumerCountImpl();
        StaticProxy staticProxy = new StaticProxy(consumerCount);
        staticProxy.queryCount();
        staticProxy.updateCount();
    }

    @Test
    public void dynamicProxyJDKTest(){
        ConsumerCountImpl consumerCountImpl = new ConsumerCountImpl();
        DynamicProxyUsingJDK dynamicProxyUsingJDK = new DynamicProxyUsingJDK();
        ConsumerCount consumerCount = (ConsumerCount) dynamicProxyUsingJDK.getProxy(consumerCountImpl);
        consumerCount.queryCount();
        consumerCount.updateCount();
    }

    @Test
    public void dynamicProxyCglibTest(){
        ConsumerCountImpl consumerCountImpl = new ConsumerCountImpl();
        ConsumerCount consumerCount = (ConsumerCount) new DynamicProxyUsingCglib().getProxy(consumerCountImpl);
        consumerCount.queryCount();
        consumerCount.updateCount();
    }
}