package mustra.musicprediction.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Bean(name = "likeFeedCountThread")
    public Executor likeFeedCountThread() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5); // 기본 스레드 개수
        taskExecutor.setMaxPoolSize(100); // 큐카파 넘어가면 스레드 축 생성
        taskExecutor.setQueueCapacity(30); // 스레드 대기 큐
        taskExecutor.setThreadNamePrefix("likeFeedCountThread-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Bean(name = "findAllFeedThread")
    public Executor findAllFeedThread() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5); // 기본 스레드 개수
        taskExecutor.setMaxPoolSize(100); // 큐카파 넘어가면 스레드 축 생성
        taskExecutor.setQueueCapacity(30); // 스레드 대기 큐
        taskExecutor.setThreadNamePrefix("findAllFeedThread-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Bean(name = "createFeedThread")
    public Executor createFeedThread() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5); // 기본 스레드 개수
        taskExecutor.setMaxPoolSize(100); // 큐카파 넘어가면 스레드 축 생성
        taskExecutor.setQueueCapacity(30); // 스레드 대기 큐
        taskExecutor.setThreadNamePrefix("createFeedThread-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Bean(name = "findRankThread")
    public Executor findRankThread() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5); // 기본 스레드 개수
        taskExecutor.setMaxPoolSize(100); // 큐카파 넘어가면 스레드 축 생성
        taskExecutor.setQueueCapacity(30); // 스레드 대기 큐
        taskExecutor.setThreadNamePrefix("findRankThread-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
