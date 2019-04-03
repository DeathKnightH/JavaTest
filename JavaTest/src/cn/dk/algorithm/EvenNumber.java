package cn.dk.algorithm;

public class EvenNumber {
    public static void main(String[] args) {
        int x = 4;
        boolean flag = isEvenNumber(x);
        boolean flagByte = isEvenNumberByte(x);
        System.out.println(flag);
        System.out.println(flagByte);
    }

    public static boolean isEvenNumber(int x){
        return x%2 == 0;
    }

    public static boolean isEvenNumberByte(int x) { return (x & 0x00000001) == 0;}
}
