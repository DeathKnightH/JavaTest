package cn.dk.basic.reflectiontest;

public class ReflectMethodsTest {

    public static void main(String[] args){

    }
    public static double getDamageTotal(double base, double crits, double defenceRate) throws Exception {
        if (defenceRate > 1 || defenceRate < 0){
            throw new Exception();
        }
        return base * crits * (1 - defenceRate);
    }
}
