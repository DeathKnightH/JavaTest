package cn.dk.basic.regextest;

public class RegExTest {
    public static void main (String args[]){
        String reg = "^([0-9]{2}){1,2}$";
        String test = "0101";
        boolean flag = test.matches(reg);

        System.out.println(flag);
    }
}
