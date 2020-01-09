package cn.dk.basic.variables.addenda;

/**
 * 浮点数规范测试
 */
public class FloatRuleTest {
    public static void main(String[] args) {
        complementTest();
    }

    public static void complementTest() {
        float a = 23.5f;
        float b = 23.7f;
        float c = 15.0f;
        System.out.printf("23.5f - 15.0f = %f\n", a - c);
        System.out.printf("23.7f - 15.0f = %f\n", b - c);
    }

    /**
     * 注意 float 的最小值，有 normal 和 denormal 两种形式，其中 MIN_VALUE 常量代表的其实是 denormal 形式，即 float 类型能表示的最趋近于 0 的数
     */
    public static void rangeTest() {
        System.out.println("Max value of float: " + Float.MAX_VALUE);
        System.out.println("Min value of float: " + Float.MIN_VALUE);
        System.out.println("Min normal number of float: " + Float.MIN_NORMAL);
    }
}
