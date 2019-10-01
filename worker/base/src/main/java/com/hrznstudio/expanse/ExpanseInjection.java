package com.hrznstudio.expanse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.SecureClassLoader;
import java.util.stream.Stream;

public class ExpanseInjection {
    public static void doInject() {
        SecureClassLoader loader = (SecureClassLoader) ExpanseInjection.class.getClassLoader();

        URLClassLoader parent = (URLClassLoader) loader.getParent();
        URLClassLoader original = (URLClassLoader) loader.getClass().getClassLoader();

        try {
            Method addUrl = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrl.setAccessible(true);
            Stream.of(original.getURLs()).filter(url -> url.toExternalForm().contains("spatial") || url.toExternalForm().contains("improbable")).forEach(url -> {
                try {
                    addUrl.invoke(parent, url);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}