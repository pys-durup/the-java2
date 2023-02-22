package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) //런타임까지 애노테이션 정보를 유지하고 싶을 경우
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

//    String value();
    String value() default "durup";
//    int number();

}


