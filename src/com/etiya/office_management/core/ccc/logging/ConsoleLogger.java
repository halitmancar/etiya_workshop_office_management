package com.etiya.office_management.core.ccc.logging;

public class ConsoleLogger implements ILogger{
    @Override
    public void log(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}
