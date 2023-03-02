package org.di2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MyContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instnace = getNewInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            Annotation annotation = f.getAnnotation(MyInject.class);
            if (annotation != null) {
                Object newInstance = getNewInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instnace, newInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return instnace;
    }

    private static <T> T getNewInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
