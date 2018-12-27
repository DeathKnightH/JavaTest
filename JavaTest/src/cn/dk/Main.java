package cn.dk;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BigDecimal value = new BigDecimal(BigInteger.ONE,2);
        System.out.println(value);
    }
}
