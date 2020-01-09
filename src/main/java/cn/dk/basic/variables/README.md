# 变量

## 0. Introduction

​	Java是静态类型语言(至少Java8是的)，所以在使用变量前必须先声明。

## 1. Index

[命名](/Naming.java)

[作用域分类](/Category.java)

[基本类型](/PrimitiveDataTypes.java)

[额外补充](/addenda)

## 2. Summary

### 2.1 基本类型

| 类型    | 数据大小/bit | 包装类    | 作为成员变量时的默认值 | 取值范围                                     |
| ------- | ------------ | --------- | ---------------------- | -------------------------------------------- |
| byte    | 8            | Byte      | 0                      | -128 ~ 127                                   |
| short   | 16           | Short     | 0                      | -32768 ~ 32767                               |
| int     | 32           | Integer   | 0                      | -2147483648 ~ 2147483647                     |
| long    | 64           | Long      | 0L                     | -9223372036854775808L ~ 9223372036854775807L |
| float   | 32           | Float     | 0.0f                   |                                              |
| double  | 64           | Double    | 0.0d                   |                                              |
| boolean | ***8***      | Boolean   | false                  | true \| false                                |
| char    | 16           | Character | '/u0000'               | '\u0000' ~ '\uffff'                          |

*关于浮点数的原理和取值范围可以参考 [补充知识的 float 部分](/addenda/float.md)

### 2.2 字面量

#### 2.2.1 Integer literals

​	基本类型中的整型包括 byte/short/int/long 四种，均能以三种格式表示:

* Decimal 十进制 
* Hexadecimal 十六进制 以 0x 为前缀
* Binary 二进制 以 0b 为前缀 （限 Java SE 7 及以后版本）

另外，字面量后缀加 `L` 或者 `l` 表示 long 长整形，其他均为 int。

#### 2.2.2 Floating-point literals

​	字面量后缀加 `f`   或 `F`  表示 float 单精度浮点，默认或者加 `D` 或 `d` 表示双精度浮点。

​	浮点数还能使用 `科学计数法` 表示，在末尾使用 `E` 或 `e` ，比如：

```java
float f1  = 123.4e2f;
```

#### 2.2.3 Character literals

​	char 可以使用任意的 Unicode-16 编码的任意字符字面量，也可以使用 unicode 转义字面量，即 '\u0000' 这种形式。

#### 2.2.4 Underscore in Numeric Literals

​	自 Java SE 7 以后，java 支持在数值字面量中添加下划线用于划分数字，来提升字面量的可读性（不会影响字面量的值）。