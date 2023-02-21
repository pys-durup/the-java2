package org.example;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        // 클래스 로딩이 끝나면, 클래스 타입의 인스턴스를 만들어서 Heap에 적재한다.
        // Book 타입의 인스턴스가 이미 존재한다

        // 클래스 타입의 인스턴스를 가져오는 방법
        // 1. 타입을 이용
        Class<Book> bookClass = Book.class;
        bookClass.getName();

        // 2. 인스턴스가 존재하는 경우
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();
        aClass.getName();

        // 3. 문자열 -> FQCN(Full Qualified Class Name)
        // 풀패키지 경로의 클래스 네임
        // 이러한 FQCN형태의 문자열이 코드에 존재한다면
        // 클래스 타입의 인스턴스를 가져오는 형태로 사용할 확률이 상당이 높다
        try {
            Class.forName("org.example.Book");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // getFields() - 클래스의 모든 필드(public 필드만)
        // public fields of the class or interface represented by this Class object.
        // getDeclaredFields() - 모든 필드
        // all the fields declared by the class or interface represented by this Class object
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        Book book1 = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true); // 필드에 접근을 가능하게 하는 메서드
                System.out.printf("%s %s \n", f, f.get(book1));
                // private 필드에 접근할 수 없다는 에러메세지 발생
                // class org.example.App cannot access a member of class org.example.Book with modifiers "private"
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        // 선언된 메서드의 정보
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(m -> {
            System.out.println(m.getName());
            System.out.println(Arrays.toString(m.getParameterTypes()));
            System.out.println(m.getParameterTypes());
            System.out.println(m.getReturnType());
            System.out.println("====================");
        });

        // 생성자
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

        // 부모 클래스
        System.out.println(MyBook.class.getSuperclass());

        // 인터페이스
//        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        // modifiers를 이용한 필드정보
//        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
//            int modifiers = f.getModifiers();
//            System.out.println(f);
//            System.out.println(Modifier.isPrivate(modifiers));
//            System.out.println(Modifier.isStatic(modifiers));
//            System.out.println(Modifier.isPublic(modifiers));
//        });


        // modifiers를 이용한 메서드정보
//        Arrays.stream(Book.class.getMethods()).forEach(m -> {
//            int modifiers = m.getModifiers();
//            System.out.println(Modifier.isPrivate(modifiers));
//            System.out.println(Modifier.isStatic(modifiers));
//            System.out.println(Modifier.isPublic(modifiers));
//        });
    }
}
