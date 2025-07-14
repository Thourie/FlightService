package com.thourie.flightservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String DRIVER_KEY = "db.driver";


    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection( PropertiesUtil.get(URL_KEY),
                                            PropertiesUtil.get(USER_KEY),
                                            PropertiesUtil.get(PASSWORD_KEY));
    }

}
