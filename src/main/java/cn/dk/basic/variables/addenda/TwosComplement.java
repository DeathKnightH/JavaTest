package cn.dk.basic.variables.addenda;

/**
 * 二进制补码
 */
public class TwosComplement {
    /**
     * Java的整型都是以二进制补码的形式存储
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = -1;
        System.out.println("binary of '-1': " + Integer.toBinaryString(i));
        System.out.println("binary of '1': " + Integer.toBinaryString(1));
        i = -8;
        System.out.println("binary of '-8': " + Integer.toBinaryString(i));
        System.out.println("binary of '8': " + Integer.toBinaryString(8));
        i = -10;
        System.out.println("binary of '-10': " + Integer.toBinaryString(i));
        System.out.println("binary of '10': " + Integer.toBinaryString(10));
    }

    /**
     * 由于补码的性质，计算减法可以使用补码相加，
     */
    public static void add() {
        // Integer 类型的模为32 8 - 1 = 8 + (2^32 - 1) = 8 + (-1)，-1的补码表示正好是 (2^32 - 1)
        System.out.println("8 - 1 = " + (8 + 0b11111111111111111111111111111111));
    }
}
