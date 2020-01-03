package cn.dk.basic.variables;

/**
 * Java语言有四种 variables
 * Instance variables 实例变量
 * Class variables 类变量
 * Local variables 本地变量
 * Parameters 参数变量
 */
public class Category {
    /**
     * This is a instance variable
     */
    int instanceVariable;

    /**
     * This is a class variable
     */
    static int classVariable;

    /**
     * Between '(' and ')' is a parameter
     *
     * @param parameterVariable This is a parameter
     */
    public static void function(int parameterVariable) {
        // This is a local variable
        int localVariable;
    }
}
