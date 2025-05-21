package com.playground.logging.framework.controller;
import com.playground.logging.framework.service.ServiceUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    private final ServiceUtil serviceUtil;

    public LoggingController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @GetMapping("/log")
    public String logMessage(@RequestParam String message) {
        return serviceUtil.logAndReturn(message);
    }

    @GetMapping("/log/level")
    public String logAtLevel(@RequestParam String message, @RequestParam String level) {
        return serviceUtil.logAtLevel(message, level);
    }

    @GetMapping("/log/format")
    public String formatMessage(@RequestParam String template, @RequestParam String value) {
        return serviceUtil.formatMessage(template, value);
    }

    @GetMapping("/log/count")
    public int getLogCount() {
        return serviceUtil.getLogCount();
    }

    @GetMapping("/util/reverse")
    public String reverse(@RequestParam String input) {
        return serviceUtil.reverse(input);
    }

    @GetMapping("/util/capitalize")
    public String capitalize(@RequestParam String input) {
        return serviceUtil.capitalize(input);
    }

    @GetMapping("/util/factorial")
    public long factorial(@RequestParam int n) {
        return serviceUtil.factorial(n);
    }

    @GetMapping("/util/isprime")
    public boolean isPrime(@RequestParam int n) {
        return serviceUtil.isPrime(n);
    }

    @GetMapping("/log/perftest")
    public String logPerformanceTest(@RequestParam(defaultValue = "1000000") int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            serviceUtil.logAndReturn("Performance test message " + i);
        }
        long end = System.currentTimeMillis();
        return "Logged " + count + " messages in " + (end - start) + " ms";
    }
}
