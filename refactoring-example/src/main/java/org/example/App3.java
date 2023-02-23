package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Book2> book2Class = Book2.class;
        // 기본 생성자
        Constructor<Book2> constructor = book2Class.getConstructor(null);
        Book2 book2 = constructor.newInstance();
        System.out.println(book2);

        // String을 파라미터로 받는 생성자
        Constructor<Book2> constructor2 = book2Class.getConstructor(String.class);
        // 객체를 만들때 파라미터를 넘겨줘야 함.
        Book2 book21 = constructor2.newInstance("myBook");
        System.out.println(book21);

        // Field 값 가져오기 - static
        Field a = Book2.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "AAAAA");
        System.out.println(a.get(null));

        // Field 값 가져오기 - 인스턴스가 있어야만 가져올 수 있는 필드
        Field b = Book2.class.getDeclaredField("B");
        // 위에서 만들어둔 boo2 인스턴스를 이용한다
        b.setAccessible(true);
        System.out.println(b.get(book2));
        b.set(book2, "BBBBBBB");

    }
}
