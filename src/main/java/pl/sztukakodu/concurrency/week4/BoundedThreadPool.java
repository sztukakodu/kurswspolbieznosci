package pl.sztukakodu.concurrency.week4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BoundedThreadPool {

    /**
     * Creates bounded thread pool that accepts up to {@param limit} tasks waiting in queue.
     * It counts unaccepted tasks, and when that number exceeds {@param limit} it shutdowns itself.
     */
    public static ExecutorService create(int minThreads, int maxThreads, long keepAliveTime, TimeUnit unit, int limit) {
        final AtomicInteger failedCount = new AtomicInteger(1);
        return new ThreadPoolExecutor(
            minThreads,
            maxThreads,
            keepAliveTime,
            unit,
            new LinkedBlockingQueue<>(limit),
            (runnable, executor) -> {
                if (failedCount.get() < limit) {
                    System.err.println("Failed to accept task... #" + failedCount.getAndIncrement());
                } else if (!executor.isShutdown()) {
                    System.err.println("Closing thread pool.");
                    executor.shutdown();
                }
            }
        );
    }
}
