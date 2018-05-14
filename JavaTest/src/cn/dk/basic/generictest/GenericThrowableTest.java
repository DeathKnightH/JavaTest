package cn.dk.basic.generictest;

public class GenericThrowableTest<T extends Throwable> {
    public void doSomeThing()throws T{
            System.out.println("Success");
    }
}
