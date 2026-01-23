package com.apress.spring6recipes.executors;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {

    public static void main(String[] args) {

        var task = new DemonstrationRunnable();

        // 1. 이전 스레드를 재사용하려고 시도하는 스레드 풀 생성
        try (var cachedThreadPoolExecutorService = Executors.newCachedThreadPool()) {
            if (cachedThreadPoolExecutorService.submit(task) == null) {
                printStatus(cachedThreadPoolExecutorService);
            }
        }

        // 2. 최대 스레드 갯수를 지정하고 큐에 넣는 스레드 풀
        try (var fixedThreadPool = Executors.newFixedThreadPool(100)) {
            if (fixedThreadPool.submit(task) == null) {
                printStatus(fixedThreadPool);
            }
        }

        // 3. 한 번에 하나의 스레드만 사용
        try (var singleThreadPool = Executors.newSingleThreadExecutor()) {
            if (singleThreadPool.submit(task) == null) {
                printStatus(singleThreadPool);
            }
        }

        // 4. 작업 수행 결과를 알 수 있도록 지원
        try (var es = Executors.newCachedThreadPool()){
            if (es.submit(task, Boolean.TRUE).equals(Boolean.TRUE)) {
                System.out.println("Job has finished!");
            }
        }

        // 5. 실행되는 작업마다 가상 스레드를 생성
        try (var vt = Executors.newVirtualThreadPerTaskExecutor()){
            if (vt.submit(task) == null) {
                printStatus(vt);
            }
        }

        // 6. TimerTask처럼 동작하는 스레드 풀 생성
        try (var scheduledExecutorService = Executors.newScheduledThreadPool(10)) {
            if (scheduledExecutorService.schedule(task, 30, TimeUnit.SECONDS) == null) {
                printStatus(scheduledExecutorService);
            }

            // 예외가 발생하거나 cancel 메서드가 호출되기 전까지는 멈추지 않는다...
            scheduledExecutorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
        }
    }

    static void printStatus(Object executor) {
        var type = executor.getClass().getSimpleName();
        var datetime = LocalDateTime.now();
        System.out.printf("The %s has succeeded at %s%n", type, datetime.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
