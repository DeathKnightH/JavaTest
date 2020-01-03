package cn.dk.basic.variables;

/**
 * 变量命名 name of variables
 *
 * @author HEH223
 */
public class Naming {
    /**
     * 变量名称只能以 unicode 编码的 letters/'$'/'_' 开头，不能以 digits 或者 其他特殊字符开头
     * 但是官方约定尽量不要使用 '$' 和 '_'
     */
    public static void namePrefix() {
        int start123;
        int $start123;
        int _start123;
        /// 便以失败，不允许以 digits 开头
        //int 1start123;
    }

    /**
     * 名称由不限长度的 unicode 编码的 letters / digits / '$' / '_' 组成，不能包含空格
     */
    public static void naming() {
        int abc123z_da_$;
        /// 编译失败，不允许包含空格
        //int das dasd;
    }
}
