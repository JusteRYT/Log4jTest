package com.example;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ColoredPatternLayout extends Layout {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public String format(LoggingEvent event) {
        String message = (String) event.getMessage();
        String level = event.getLevel().toString();
        String className = event.getLoggerName(); // Get logger name directly

        String colorCode;
        switch (level) {
            case "DEBUG":
                colorCode = "\u001B[34m"; // Синий
                break;
            case "INFO":
                colorCode = "\u001B[32m"; // Зеленый
                break;
            case "WARN":
                colorCode = "\u001B[33m"; // Желтый
                break;
            case "ERROR":
                colorCode = "\u001B[31m"; // Красный
                break;
            case "FATAL":
                colorCode = "\u001B[31;1m"; // Жирный красный
                break;
            default:
                colorCode = "";
        }

        String formattedDate = dateFormat.format(new Date(event.getTimeStamp()));
        String formattedLevel = String.format("%-5s", colorCode + level + "\u001B[0m"); // Use %-5s for left alignment
        String formattedClassName = String.format("%-20s", className);


        String formattedMessage = String.format("%s %s %s -  %s",
                formattedDate,
                formattedLevel,
                formattedClassName,
                message);


        return String.format("%s\n", formattedMessage);
    }

    @Override
    public boolean ignoresThrowable() {
        return true;
    }

    @Override
    public void activateOptions() {
        //Nothing to do
    }
}
