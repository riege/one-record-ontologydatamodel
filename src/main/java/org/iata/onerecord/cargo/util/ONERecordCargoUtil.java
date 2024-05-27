package org.iata.onerecord.cargo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
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
            T instance = clazz.getConstructor(new Class[0]).newInstance();
            Field field = Class.forName("org.iata.onerecord.cargo.Vocabulary")
                .getDeclaredField("s_c_" + clazz.getSimpleName());
            Set<String> typeValue = new LinkedHashSet<>(Collections.singletonList((String) field.get(null)));
            Method typeSetter = clazz.getMethod("setTypes", Set.class);
            typeSetter.invoke(instance, typeValue);
            return instance;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchFieldException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Helper method to build a Set (of LogisticsObject)
     *
     * @param <T> the type of elements maintained by this set
     * @return Empty set built from the provided class
     */
    public static final <T> Set<T> buildSet() {
        // LinkedHashSet used to keep the order in which elements were inserted
        return new LinkedHashSet<>();
    }

    /**
     * Helper method to build a Set (of LogisticsObject)
     *
     * @param <T> the type of elements maintained by this set
     * @param singleEntry is added to the generated and returned Set
     * @return Set built from the provided data, null if provided data is null
     */
    public static final <T> Set<T> buildSet(T singleEntry) {
        // LinkedHashSet used to keep the order in which elements were inserted
        return singleEntry == null
            ? null
            : new LinkedHashSet<>(Collections.singletonList(singleEntry));
    }

    /**
     * Helper method to build a Set (of LogisticsObject)
     *
     * @param <T> the type of elements maintained by this set
     * @param array entries are added to the generated and returned Set
     * @return Set built from the provided data even if the array is empty, null if provided data is null
     */
    public static final <T> Set<T> buildSet(T[] array) {
        // LinkedHashSet used to keep the order in which elements were inserted
        return array == null
            ? null
            : new LinkedHashSet<>(Arrays.asList(array));
    }

    /**
     * Helper method to build a Set (of LogisticsObject)
     *
     * @param <T> the type of elements maintained by this set
     * @param list entries are added to the generated and returned Set
     * @return Set built from the provided data even if the list is empty, null if provided data is null
     */
    public static final <T> Set<T> buildSet(List<T> list) {
        // LinkedHashSet used to keep the order in which elements were inserted
        return list == null
            ? null
            : new LinkedHashSet<>(list);
    }

}
