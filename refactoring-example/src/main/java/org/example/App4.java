package org.example;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App4 {
    public static void main(String[] args) {

        Constructor<Book2> constructor = null;
        try {
            constructor = Book2.class.getConstructor(null);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        AnnotatedType annotatedReturnType = constructor.getAnnotatedReturnType();
        System.out.println(annotatedReturnType);

        Field[] declaredFields = Book2.class.getDeclaredFields();
        Method[] declaredMethods = Book2.class.getDeclaredMethods();
        Constructor<?>[] declaredConstructors = Book2.class.getDeclaredConstructors();


        Arrays.stream(declaredFields)
                .forEach(System.out::println);
    }
}
