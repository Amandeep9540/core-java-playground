package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionIntro{
    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> teacherClassObj = Class.forName("Reflection.Teacher");
        inspectMethods(teacherClassObj);
        inspectVariables(teacherClassObj);
    }

    public static void inspectMethods(Class teacherClassObj){
        Method[] methods = teacherClassObj.getMethods();//Return all public method of its own and superclass.

            for(Method method : methods){
                System.out.println("teacherClassObj.getMethods() -- method name -- "+method.getName());
                System.out.println("teacherClassObj.getMethods() -- method parameter -- "+ Arrays.stream(method.getTypeParameters()).toList());
                System.out.println("teacherClassObj.getMethods() -- method return type -- "+method.getReturnType());
                System.out.println("-_-_-_-_-_-_");
            }

        System.out.println("-----\n-----\n-----\n");
        Method[] declaredMethods = teacherClassObj.getDeclaredMethods();//Return all method of own class accept private.

        for(Method method : declaredMethods){
            System.out.println("teacherClassObj.getDeclaredMethods() -- method name -- "+method.getName());
            System.out.println("teacherClassObj.getDeclaredMethods() -- method parameter -- "+ Arrays.stream(method.getTypeParameters()).toList());
            System.out.println("teacherClassObj.getDeclaredMethods() -- method return type -- "+method.getReturnType());
            System.out.println("-_-_-_-_-_-_");
        }
    }

    public static void inspectVariables(Class teacherClassObj){
        Field[] publicAndPrentFields = teacherClassObj.getFields();
            for(Field field:publicAndPrentFields){
                System.out.println("teacherClassObj.getFields() -- field name -- "+field.getName());
                System.out.println("teacherClassObj.getFields() -- field datatype -- "+field.getGenericType().getTypeName());
                System.out.println("teacherClassObj.getFields() -- field datatype -- "+ Modifier.toString(field.getModifiers()));
                System.out.println("-_-_-_-_-_-_");
            }

        System.out.println("-----\n-----\n-----\n");

        Field[] ownAllFields = teacherClassObj.getDeclaredFields();
        for(Field field:ownAllFields){
            System.out.println("teacherClassObj.getDeclaredFields() -- field name -- "+field.getName());
            System.out.println("teacherClassObj.getDeclaredFields() -- field datatype -- "+field.getGenericType().getTypeName());
            System.out.println("teacherClassObj.getDeclaredFields() -- field datatype -- "+ Modifier.toString(field.getModifiers()));
            System.out.println("-_-_-_-_-_-_");
        }
    }

}