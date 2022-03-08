package bf;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) {

        int N = 8;            //工人数
//        // 固定线程的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < N; ++i) {
//            int tt = i;
//            executorService.execute(() -> {
//                System.out.println("i = " + tt);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        executorService.shutdown();
//
//        // 非固定线程数量的线程池, 使用Semaphore控制并发量
//        Semaphore semaphore = new Semaphore(5); //机器数目
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < N; ++i) {
//            exec.execute(new Worker(semaphore, atomicInteger));
//        }
//        exec.shutdown();

        // 固定线程的定时线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("scheduledExecutorService    = " + Instant.now().getEpochSecond() + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("scheduledExecutorService = " + Instant.now().getEpochSecond() + Thread.currentThread().getName());
        }, 2, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("scheduledExecutorService = " + Instant.now().getEpochSecond() + Thread.currentThread().getName());
        }, 2, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("scheduledExecutorService = " + Instant.now().getEpochSecond() + Thread.currentThread().getName());
        }, 2, 2, TimeUnit.SECONDS);
    }

}
