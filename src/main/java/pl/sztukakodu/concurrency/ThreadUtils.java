package pl.sztukakodu.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    public static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void println(String line) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + line);
    }
}
