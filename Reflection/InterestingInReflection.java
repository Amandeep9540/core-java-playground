package Reflection;

import java.lang.reflect.Field;

public class InterestingInReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        breakSingletonPattern();
//        changeFinalVariableValue();
        breakImmutableClass();
    }

    public static void breakSingletonPattern() throws NoSuchFieldException, IllegalAccessException {
        Class<SingletonClass> singletonClassClass = SingletonClass.class;
        Object heavyObj = SingletonClass.getInstance();
        Field instance = singletonClassClass.getDeclaredField("instance");
        instance.setAccessible(true); // required if variable is private
        instance.set(heavyObj,null);
        Object heavyObj2 = SingletonClass.getInstance();
    }

    public static void changeFinalVariableValue() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Teacher teacher = new Teacher("kendriya vidyalaya");
        System.out.println("school name(before reflection) :: "+teacher.schoolName);

        Class<? extends Teacher> teacherClass = teacher.getClass();
        Field schoolName = teacherClass.getField("schoolName");
        schoolName.setAccessible(true);
        schoolName.set(teacher,"shaheed bhagat singh inter college");

        System.out.println("school name(after reflection) :: "+teacher.schoolName);

    }

    public static void breakImmutableClass() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        ImmutableClass immutableObj = new ImmutableClass("Amandeep",25);
        System.out.println("1.Name is :: "+immutableObj.getName()+" and age is :: "+immutableObj.getAge());
        Class<? extends ImmutableClass> immutableClass = immutableObj.getClass();
        Field field = immutableClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(immutableObj,"Aman");
        System.out.println("2.Name is :: "+immutableObj.getName()+" and age is :: "+immutableObj.getAge());
    }
}
