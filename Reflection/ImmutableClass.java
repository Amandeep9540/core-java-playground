package Reflection;

public class ImmutableClass {
    private final String name;
    private final Integer age;

    ImmutableClass(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
