package Reflection;

public class SingletonClass {
    private static volatile Object instance;

    private SingletonClass() {}

    public static Object getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    System.out.println("creating heavy object");
                    instance = "Heavy Object Created";
                }
            }
        }
        return instance;
    }
}
