package cn.dk.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxyUsingCglib implements MethodInterceptor {
    public Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("cglib动态代理-委托方法执行前");
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib动态代理-委托方法执行后");
        return result;
    }
}
