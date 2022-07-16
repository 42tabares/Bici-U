package com.bici_u.tools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    //Takes an instance of an object and returns a String with its atributes separated by ";"
    public static String toOutputFormat(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> classObject = object.getClass();
        List<String> listString = new ArrayList<>();
        for (Field field : classObject.getDeclaredFields()) {
            Object objectMethod = classObject.getMethod("get" + firstToUpperCase(field.getName())).invoke(object);
            listString.add(objectMethod.toString());
        }
        return String.join(";", listString);
    }

    public static String firstToUpperCase(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
