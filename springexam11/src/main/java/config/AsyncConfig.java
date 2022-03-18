package config;

import java.util.concurrent.Executor;

import javax.annotation.Resource;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//1.Configuration를 활용하여 Bean객체 등록
@Configuration
//2.EnableAsync를 활용해서 비동기 프로세서를 사용하겠다고 선언
@EnableAsync
									//상속
public class AsyncConfig implements AsyncConfigurer{
	//샘플 기본 Thread 수
	private static int TASK_CORE_POOL_SIZE = 2;
	//샘플 최대 Thread 수 
	private static int TASK_MAX_POOL_SIZE = 4;
	//샘플 QUEUE 수 
	private static int TASK_QUEUE_CAPACITY = 0;
	//샘플 Thread Bean NAME
	private static String EXECUTOR_BEAN_NAME = "executor";

	
	/*
	 * AsyncConfigurer을 사용하고 ThreadPoolTaskExecutor를 활용하여 Excecutor를 다중으로 생성한다.
	 * AsyncConfigurer를 사용했기 때문에 ExcetptionHandler 연결이 가능하여 연결하였고
	 * @Async를 활용해서 여러 Thread를 생성해 필요한 Executor과 연결하여 사용한다.
	 */
			//샘플 Thread
	@Resource(name="executor")
	private ThreadPoolTaskExecutor executor;

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		setExecutor(executor);
		return executor;
	}
	public void setExecutor(ThreadPoolTaskExecutor executor) {
		executor.setCorePoolSize(TASK_CORE_POOL_SIZE);
		executor.setMaxPoolSize(TASK_MAX_POOL_SIZE);
		executor.setQueueCapacity(TASK_QUEUE_CAPACITY);
		executor.setBeanName(EXECUTOR_BEAN_NAME);
		executor.initialize();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
