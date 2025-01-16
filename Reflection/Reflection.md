# Reflection in Java

## Introduction
Reflection in Java is a powerful feature provided by the `java.lang.reflect` package. It allows a program to inspect and manipulate classes, methods, fields, and constructors at runtime, even if they are private or protected. By leveraging reflection, developers can dynamically interact with an object's properties and behavior without knowing its structure at compile time.

Reflection is commonly used in frameworks, libraries, and tools that need to operate on unknown classes, methods, or fields during runtime.

In reflection, we need Class object to perform reflection related operations. There are three ways to get the Class object of any class.


```java
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
            //1 way -- Using Class.forName() with the fully qualified name of the class
        Class<?> teacherClassObj = Class.forName("Teacher");
            //2 way -- Using the .class syntax
        Class<Teacher> teacherClassObj2 = Teacher.class;
            //3 way -- Using the getClass() method on an object instance
        Class<?> teacherClassObj3 = new Teacher().getClass();
    }
}
```
---

## Where Reflection is Used
1. **Frameworks and Libraries**: Popular frameworks like Spring, Hibernate, and JUnit use reflection for dependency injection, object creation, and method invocation.
2. **Debugging and Testing Tools**: Tools like debuggers and testing frameworks use reflection to inspect classes and objects at runtime.
3. **Dynamic Proxies**: Used in scenarios like aspect-oriented programming (AOP) for creating proxy classes at runtime.
4. **Serialization and Deserialization**: Reflection is often used to access object fields for serialization purposes.

---

## Interesting Questions
1. **[How to break the Singleton Pattern using Reflection?](InterestingInReflection.java)**
    - Reflection can break the singleton design pattern by dynamically invoking constructor or setting a variable value to null.

2. **[How to reinitialize the value of a final variable using Reflection?](InterestingInReflection.java)**
    - Generally, a `final` variable cannot be reinitialized, but using reflection, it is possible to modify the value of a final variable.

---

## Resources
- [Java Reflection API Documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html)
- [Baeldung - Guide to Java Reflection](https://www.baeldung.com/java-reflection)
- [How Reflection Works in Java](https://www.geeksforgeeks.org/reflection-in-java/)

---
