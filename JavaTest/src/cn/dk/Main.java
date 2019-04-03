package cn.dk;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        String message = String.valueOf(-1232131);
        int i = -120003;
        i--;
        int r = i & 0xffffffff;

        System.out.println(i);
        System.out.println(r);
        System.out.println(message);

    }
}
