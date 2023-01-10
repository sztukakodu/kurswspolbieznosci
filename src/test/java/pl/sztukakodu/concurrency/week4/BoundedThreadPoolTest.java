package pl.sztukakodu.concurrency.week4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoundedThreadPoolTest {
    @Test
    public void shouldShutdownAfterFailedTasks() throws InterruptedException {
        Runnable sleepingTask = new SleepingTask(1);

        ExecutorService pool = BoundedThreadPool.create(1, 4, 30, TimeUnit.SECONDS, 10);
        while (!pool.isShutdown()) {
            pool.submit(sleepingTask);
        }

        pool.awaitTermination(10, TimeUnit.SECONDS);
        assertTrue(pool.isShutdown());
        assertTrue(pool.isTerminated());
    }

    private static class SleepingTask implements Runnable {
        private static final AtomicInteger COUNTER = new AtomicInteger(1);
        private final int sleepSeconds;

        public SleepingTask(int sleepSeconds) {
            this.sleepSeconds = sleepSeconds;
        }

        @Override
        public void run() {
            int taskId = COUNTER.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + ":: Starting long task... #" + taskId);
            deepSleep();
            System.out.println(Thread.currentThread().getName() + ":: Done #" + taskId);
        }

        private void deepSleep() {
            try {
                TimeUnit.SECONDS.sleep(sleepSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 
