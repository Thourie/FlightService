package com.thourie.flightservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    @SneakyThrows
    private static void loadProperties() {
        Class.forName("org.postgresql.Driver");
        InputStream is =  PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
        PROPERTIES.load(is);
    }

    public static String get( String key) {
        return PROPERTIES.getProperty(key);
    }
}
