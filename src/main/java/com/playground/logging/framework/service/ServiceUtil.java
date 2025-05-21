package com.playground.logging.framework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {
    private static final Logger logger = LoggerFactory.getLogger(ServiceUtil.class);
    private int logCount = 0;

    public String logAndReturn(String message) {
        logger.info("Logging message: {}", message);
        logCount++;
        return message;
    }

    public String logAtLevel(String message, String level) {
        switch (level.toUpperCase()) {
            case "INFO":
                logger.info("[INFO] {}", message);
                break;
            case "WARN":
                logger.warn("[WARN] {}", message);
                break;
            case "ERROR":
                logger.error("[ERROR] {}", message);
                break;
            default:
                logger.debug("[DEBUG] {}", message);
        }
        logCount++;
        return String.format("Logged at %s: %s", level, message);
    }

    public String formatMessage(String template, String value) {
        String formatted = template.replace("{}", value);
        logger.info("Formatted message: {}", formatted);
        logCount++;
        return formatted;
    }

    public int getLogCount() {
        return logCount;
    }

    // String utility: Reverse a string
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    // String utility: Capitalize first letter
    public String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    // Math utility: Factorial
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Math utility: Check if prime
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
