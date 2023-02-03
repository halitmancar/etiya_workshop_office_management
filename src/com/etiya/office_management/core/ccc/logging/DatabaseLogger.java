package com.etiya.office_management.core.ccc.logging;

public class DatabaseLogger implements ILogger{
    @Override
    public void log(String message) {
        System.out.println("DatabaseLogger: " + message);
    }
}
