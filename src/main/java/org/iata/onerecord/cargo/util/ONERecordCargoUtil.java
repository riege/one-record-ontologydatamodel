package org.iata.onerecord.cargo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ONERecordCargoUtil {

    /**
     * Helper method to create POJO objects properly
     *
     * @param clazz Class of the logistics object class to create
     * @return a logistics object created with correct types attribute
     */
    public static final <T> T create(Class<T> clazz) {
        try {
            T instance = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            Field field = Class.forName("org.iata.onerecord.cargo.Vocabulary")
                .getDeclaredField("s_c_" + clazz.getSimpleName());
            Set<String> typeValue = new LinkedHashSet<>(Collections.singletonList((String) field.get(null)));
            Method typeSetter = clazz.getMethod("setTypes", new Class[] { Set.class } );
            typeSetter.invoke(instance, typeValue);
            return instance;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchFieldException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
