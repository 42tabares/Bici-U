package com.bici_u.tools;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Query {

    public static <T> List<T> byAttribute(String key, String getterMethod, List<T> list) {
        List<T> queryResult = new ArrayList<>();

        if(!list.isEmpty()) {
            Class<?> classOfObject = list.get(0).getClass();
            try {
                int i = 0;
                for (Object object : list) {
                    Object actualObject = classOfObject.getMethod(getterMethod).invoke(object);
                    if (actualObject.equals(key)) {
                        queryResult.add(list.get(i));
                    }
                    i++;
                }
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return queryResult;
    }

    public static <T> List<T> byAttribute(Boolean key, String getterMethod, List<T> list) {
        List<T> queryResult = new ArrayList<>();
        Class<?> classOfObject = list.get(0).getClass();
        try {
            int i = 0;
            for (Object object : list) {
                Object actualObject = classOfObject.getMethod(getterMethod).invoke(object);
                if (actualObject.equals(key)) {
                    queryResult.add(list.get(i));
                }
                i++;
            }
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return queryResult;
    }

}
