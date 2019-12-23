package cn.dk.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK的InvocationHandler实现的动态代理类
 */
public class DynamicProxyUsingJDK implements InvocationHandler {
    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("jdk动态代理-委托方法执行前");
        result = method.invoke(this.target, args);
        System.out.println("jdk动态代理-委托方法执行后");
        return result;
    }
}
