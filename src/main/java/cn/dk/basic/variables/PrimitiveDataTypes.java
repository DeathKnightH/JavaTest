package cn.dk.basic.variables;

/**
 * Java 原始类型/基本类型
 * 共有 8 种原始类型
 * byte short int long char float double bool
 */
public class PrimitiveDataTypes {
    /**
     * byte 占用 8 bits，是带符号的二进制补码形式的整数，表示的整数范围为 -128 ~ 127
     */
    public static void byteTest() {
        byte temp = 1;
        temp = 127;
        temp = -128;
        /// 编译错误，超出了 byte 能表示的整数范围
        //temp = 128;
        //temp = -129;
    }

    /**
     * short 占用 16 bits，是带符号的二进制补码形式的整数，表示的整数范围为 -32768 ~ 32767
     */
    public static void shortTest() {
        short temp = -1;
        temp = -32768;
        temp = 32767;
        /// 编译错误，超出了 short 能表示的整数范围
        //temp = -32769;
        //temp = 32768;
    }

    /**
     * int 占用 32 bits，是带符号的二进制补码形式的整数，表示的整数范围为 -2147483648 ~ 2147483647
     * 在 jdk 8 以后，可以使用包装类 Integer 表示和使用 unsigned 无符号的整数
     */
    public static void intTest() {
        int temp = 1;
        temp = -2147483648;
        temp = 2147483647;
        /// 编译错误，超出了 int 能表示的整数范围
        //temp = -2147483649;
        //temp = 2147483648;

        // 在 jdk8 以后使用 Integer 包装类可以表示无符号的整型
        System.out.println("unsigned '2147483647': " + Integer.toUnsignedString(2147483647));
        System.out.println("unsigned '-1': " + Integer.toUnsignedString(-1));
    }

    /**
     * long 占用 64 bits，是带符号的二进制补码形式的整数，表示的整数范围为 -9223372036854775808 ~ 9223372036854775807
     * 使用字面量表示 long 整数时需要在末尾加大写的 "L"
     * 在 jdk 8 以后，可以使用包装类 Long 表示和使用 unsigned 无符号的整数
     */
    public static void longTest() {
        long temp = -1;
        /// 使用字面量表示 long 整数时需要在末尾加大写的 "L"，否则在超出 int 范围后字面量也会编译错误
        //temp = 4231231246;
        temp = 9223372036854775807L;
        temp = -9223372036854775808L;

        /// 编译错误，超出了 long 能表示的整数范围
        //temp = 9223372036854775808L;
        //temp = -9223372036854775809L;

        // 在 jdk8 以后使用 Long 包装类可以表示无符号的整型
        System.out.println("unsigned '9223372036854775807': " + Long.toUnsignedString(9223372036854775807L));
        System.out.println("unsigned '-1': " + Long.toUnsignedString(-1));
    }

    /**
     * float 占用 32 bits，是符合 IEEE 754 标准的单精度浮点数
     * java中的小数默认使用了 double 类型，如果要使用 float 类型，需要在末尾显示地加上 'f' 或者 'F'
     * 由于浮点数的原理，float 无法精确表示小数，如果需要精确表示小数（比如表示货币），需要使用 BigDecimal 类
     */
    public static void floatTest() {
        float temp = 1.0f;
        // float 无法精确表示小数
        temp = 1.0328781f;
        System.out.println(temp);
        temp = 1.23456789f;
        System.out.println(temp);
    }

    /**
     * double 占用 64 bits，是符合 IEEE 754 标准的双精度浮点数
     * java中的小数默认使用了 double 类型，也可以在末尾显示地加上 'd' 或者 'D'
     * 由于浮点数的原理，double 无法精确表示小数，如果需要精确表示小数（比如表示货币），需要使用 BigDecimal 类
     */
    public static void doubleTest() {
        double temp = 1.0;
        // double 无法精确表示小数
        temp = 3.0123485234131111d;
        System.out.println(temp);
    }

    /**
     * char 占用 16 bits，是 unicode 编码的单个字符，取值范围为 '/u0000' 到 '/uffff'，同时也是 16 bits 的无符号整型，取值范围为 0 ~ 65535
     * 声明和使用 char 时可以将它作为单个字符使用，也可以作为整数使用
     */
    public static void charTest() {
        char temp = 'd';
        temp = 65535;
        /// 编译错误，超出 char 能表示的整数范围
        //temp = -1;
        //temp = 65536;
    }

    /**
     * boolean 占用 8 bits，但是只能表示 1 bits 的数据，即 'false' 和 ‘true’
     */
    public static void booleanTest() {
        boolean temp = false;
        temp = true;
        /// 和 c++ 不同，boolean 不能直接使用整数表示
        //temp = 0;
        // 但是可以通过添加 "!= 0" 判断式把整型或者浮点数表达式转换为 boolean
        temp = 1 + 5 != 0;
    }

    /**
     * 各种基本类型的字面量展示
     */
    public static void literalsTest() {
        // The number 26, in decimal
        int decVal = 26;
        //  The number 26, in hexadecimal
        int hexVal = 0x1a;
        // The number 26, in binary
        int binVal = 0b11010;
        System.out.println("If 26 == 0x1a == 0b11010 : " + (decVal == hexVal && hexVal == binVal));

        double d1 = 123.4;
        // same value as d1, but in scientific notation
        double d2 = 1.234e2;
        System.out.println("If 123.4 == 1.234e2 : " + (d1 == d2));

        long normal = 999999999L;
        long withUnderscore = 9_9999_9999L;
        System.out.println("If 9_9999_9999L == 999999999L : " + (normal == withUnderscore));

        char c = '\u00ff';
        // 这里注意 unicode 转义的写法，因为Unicode转义会在解析代码前完成，所以即使\\u 存在于注释中也会被转义，所以需要在前面多加一个 '\'字符
        System.out.println("Character of '\\u00ff' : " + c);
    }

    public static void main(String[] args) {
        literalsTest();
    }

}
