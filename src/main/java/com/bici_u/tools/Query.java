package com.bici_u.tools;

import com.bici_u.management.Bicycle;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Query {

    public static List<Object> byStringAttribute(String ID,String getterMethod,List list) {
        List<Object> queryResult = new ArrayList<>();
        Class<?> classOfObject = list.get(0).getClass();
        try {
            int i = 0;
            for (Object object : list) {
                Object actualObject = classOfObject.getMethod(getterMethod).invoke(object);
                if (actualObject.equals(ID)) {
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
