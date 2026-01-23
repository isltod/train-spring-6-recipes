package com.apress.spring6recipes.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class Utils {

    private Utils() {}

    public static void sleep(long millis) {
        sleep(Duration.ofMillis(millis));
    }

    public static void sleep(long millis, TimeUnit timeUnit) {
        sleep(Duration.of(millis, timeUnit.toChronoUnit()));
    }

    public static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
