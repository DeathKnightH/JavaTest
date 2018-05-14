package cn.dk.basic.generictest;

import java.util.function.Supplier;

public class Pair<T>{
    private T first;
    private T second;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public static <T> Pair<T> makePair(Supplier<T> construct){
        return new Pair<>(construct.get(), construct.get());
    }

    public static <T> Pair<T> makePair(Class<T> tClass){
        try {
            return new Pair<>(tClass.newInstance(), tClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
