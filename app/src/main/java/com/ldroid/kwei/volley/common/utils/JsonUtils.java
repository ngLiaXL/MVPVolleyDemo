package com.ldroid.kwei.volley.common.utils;


import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class JsonUtils {

    private JsonUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static <T> String toJson(Object obj, Type typeOfT) {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                .toJson(obj, typeOfT);
    }

    public static String toJson(Object obj) {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                .fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                .fromJson(json, typeOfT);
    }

}
