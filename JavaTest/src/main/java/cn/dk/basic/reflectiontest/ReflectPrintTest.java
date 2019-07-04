package cn.dk.basic.reflectiontest;

import cn.dk.basic.objecttest.Employee;
import cn.dk.basic.objecttest.Manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectPrintTest {
    public static void main(String[] args){
        printClassInfo(Employee.class);
        System.out.println("");
        printDeclaredClassInfo(Employee.class);

    }

    public static void printClassInfo(Class clazz){
        printFields(clazz);
        printConstructors(clazz);
        printMethods(clazz);
    }

    public static void printDeclaredClassInfo(Class clazz){
        printDeclaredFields(clazz);
        printDeclaredConstructors(clazz);
        printDeclaredMethods(clazz);
    }

    public static void printConstructors(Class clazz){
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("Constructors:");
        //打印类的构造方法
        for(Constructor c: constructors){
            StringBuilder stringBuilder = new StringBuilder();
            //方法名称
            String name = c.getName();
            //修饰符
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0){
                stringBuilder.append(modifiers).append(" ");
            }
            stringBuilder.append(name).append("(");

            //参数列表
            Class[] parameters = c.getParameterTypes();
            for(int i = 0; i < parameters.length; i++){
                if(i > 0){
                    stringBuilder.append(", ");
                }
                stringBuilder.append(parameters[i].getName());
            }
            stringBuilder.append(");");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printDeclaredConstructors(Class clazz){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("Declared Constructors:");
        //
        for(Constructor c: constructors){
            StringBuilder stringBuilder = new StringBuilder();
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0){
                stringBuilder.append(modifiers).append(" ");
            }
            String name = c.getName();

            stringBuilder.append(name).append("(");
            Class[] parameters = c.getParameterTypes();
            for (int i = 0; i<parameters.length; i++){
                if(i > 0){
                    stringBuilder.append(", ");
                }
                stringBuilder.append(parameters[i].getName());
            }
            stringBuilder.append(");");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printFields(Class clazz){
        Field[] fields = clazz.getFields();
        System.out.println("Fields:");

        for(Field f: fields){
            StringBuilder stringBuilder = new StringBuilder();
            //成员修饰符
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0){
                stringBuilder.append(modifiers).append(" ");
            }
            //成员类型
            String type  = f.getType().getName();
            //成员名称
            String name = f.getName();
            stringBuilder.append(type).append(" ").append(name).append(";");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printDeclaredFields(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Declared Fields:");

        for(Field f: fields){
            StringBuilder stringBuilder = new StringBuilder();
            //成员修饰符
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0){
                stringBuilder.append(modifiers).append(" ");
            }
            //成员类型
            String type  = f.getType().getName();
            //成员名称
            String name = f.getName();
            stringBuilder.append(type).append(" ").append(name).append(";");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printMethods(Class clazz){
        Method[] methods = clazz.getMethods();
        System.out.println("Methods:");

        for(Method m : methods){
            StringBuilder stringBuilder = new StringBuilder();
            String modifier = Modifier.toString(m.getModifiers());
            if(modifier.length() > 0){
                stringBuilder.append(modifier).append(" ");
            }
            String returnType = m.getReturnType().getName();
            String name = m.getName();

            stringBuilder.append(returnType).append(" ").append(name).append("(");
            Class[] parameters = m.getParameterTypes();
            for(int i = 0; i < parameters.length; i++){
                if (i > 0){
                    stringBuilder.append(", ");
                }
                stringBuilder.append(parameters[i].getName());
            }
            stringBuilder.append(");");
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printDeclaredMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");

        for(Method m : methods){
            StringBuilder stringBuilder = new StringBuilder();
            String modifier = Modifier.toString(m.getModifiers());
            if(modifier.length() > 0){
                stringBuilder.append(modifier).append(" ");
            }
            String returnType = m.getReturnType().getName();
            String name = m.getName();

            stringBuilder.append(returnType).append(" ").append(name).append("(");
            Class[] parameters = m.getParameterTypes();
            for(int i = 0; i < parameters.length; i++){
                if (i > 0){
                    stringBuilder.append(", ");
                }
                stringBuilder.append(parameters[i].getName());
            }
            stringBuilder.append(");");
            System.out.println(stringBuilder.toString());
        }
    }
}
