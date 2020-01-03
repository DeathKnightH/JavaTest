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
}
