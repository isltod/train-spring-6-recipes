package com.apress.spring6recipes.executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ComponentScan
public class ExecutorsConfiguration {

    @Bean
    public TaskExecutorAdapter taskExecutorAdapter() {
        return new TaskExecutorAdapter(Executors.newCachedThreadPool());
    }

    @Bean
    // job마다 새로 스레드 생성, 풀링이나 재사용하지 않음
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    // 동기 방식으로 스레드 실행 후 join 호출...스레드 무시하고 run 시킨것과 비슷하다고...
    public SyncTaskExecutor syncTaskExecutor() {
        return new SyncTaskExecutor();
    }

    @Bean
    public ScheduledExecutorTask scheduledExecutorTask(Runnable task) {
        var scheduledExecutorTask = new ScheduledExecutorTask();
        scheduledExecutorTask.setPeriod(50);
        scheduledExecutorTask.setRunnable(task);
        return scheduledExecutorTask;
    }

    @Bean
    // ScheduledExecutorTask 빈에 정의된 job을 자동으로 트리거...
    public ScheduledExecutorFactoryBean scheduledExecutorFactoryBean(ScheduledExecutorTask scheduledExecutorTask) {
        ScheduledExecutorFactoryBean scheduledExecutorFactoryBean = new ScheduledExecutorFactoryBean();
        scheduledExecutorFactoryBean.setScheduledExecutorTasks(scheduledExecutorTask);
        return scheduledExecutorFactoryBean;
    }

    @Bean
    // 모든 기능을 다 가진 구현체? 그럼 이걸 쓰면 만사 ok?
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        var taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return taskExecutor;
    }

    @Bean
    public ConcurrentTaskExecutor virtualTaskExecutor() {
        var virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();
        return new ConcurrentTaskExecutor(virtualThreadExecutor);
    }
}
