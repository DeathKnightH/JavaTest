package cn.dk.basic.proxytest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibTraceHandler implements MethodInterceptor {
    private Enhancer enhancer= new Enhancer();
    public Object getProxyInstance(Class superClazz){
        enhancer.setSuperclass(superClazz);
        enhancer.setCallback(this);
        return enhancer.create(new Class[]{String.class,String.class,double.class}, new Object[]{"ppx","null",4396});
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println(o.toString());
        System.out.println("." + method.getName() + "(");
        if (objects != null){
            for (int i = 0; i<objects.length; i++){
                System.out.println(objects[i]);
                if (i < objects.length - 1){
                    System.out.println(",");
                }
            }
        }
        System.out.println(")");
        return methodProxy.invokeSuper(o, objects);
    }
}
