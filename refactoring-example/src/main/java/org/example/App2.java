package org.example;

import java.util.Arrays;

public class App2 {
    public static void main(String[] args) {
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

        // 애노테이션 조회
        Arrays.stream(Book.class.getDeclaredFields()).forEach(field -> {
            Arrays.stream(field.getAnnotations()).forEach(System.out::println);
        });

        // 애노테이션 활용
        Arrays.stream(Book.class.getDeclaredFields()).forEach(field -> {
            Arrays.stream(field.getAnnotations()).forEach( annotation -> {
                if ( annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println(myAnnotation.value());
                }
            });
        });
    }
}
