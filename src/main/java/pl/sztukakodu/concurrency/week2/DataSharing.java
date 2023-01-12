package pl.sztukakodu.concurrency.week2;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// Week 2 HomeWork example solution
class DataSharing {
    public static void main(String[] args) throws InterruptedException {
        // initialize shared data
        Data data = new Data();
        // initialize writers & reader threads
        List<Thread> threads = List.of(
            new Thread(new Writer(data, 1, 50), "W1"),
            new Thread(new Writer(data, 100, 500), "W2"),
            new Thread(new Reader(data), "R1")
        );
        // initialize monitor thread
        Thread monitor = new Thread(new Monitor(threads));
        monitor.setDaemon(true);

        // start all threads
        monitor.start();
        threads.forEach(Thread::start);

        // wait some time
        TimeUnit.SECONDS.sleep(10);

        // kill all threads except daemon one (monitor thread)
        for (Thread t : threads) {
            t.interrupt();
        }
    }

    static class Data {
        private Integer value;

        /**
         * Store new value.
         * Wait if value is not null.
         */
        public synchronized void put(Integer newValue) throws InterruptedException {
            while (value != null) {
                wait();
            }
            value = newValue;
            notify();
        }

        /**
         * Read and clear stored value.
         * Wait if value is null.
         */
        public synchronized Integer pop() throws InterruptedException {
            while (value == null) {
                wait();
            }
            int tmpValue = value;
            value = null;
            notify();
            return tmpValue;
        }
    }

    static class Writer implements Runnable {

        private final Data data;
        private final Random random;

        public Writer(Data data, int from, int to) {
            this.data = data;
            this.random = new Random(from, to);
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    data.put(random.nextInt());
                    Thread.sleep(2_000);
                }
            } catch (InterruptedException e) {
                System.out.println("Writer interrupted. Finishing work.");
            }
        }
    }

    static class Reader implements Runnable {
        private Data data;

        public Reader(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Integer value = data.pop();
                    Integer sum = intSum(value);
                    System.out.println("Sum of integers from 1 to " + value + " is " + sum);
                    Thread.sleep(1_000);
                }
            } catch (InterruptedException e) {
                System.out.println("Reader interrupted. Finishing work.");
            }
        }

        private Integer intSum(int value) {
            int result = 0;
            for (int i = 1; i < value; i++) {
                result += value;
            }
            return result;
        }
    }

    static class Monitor implements Runnable {
        private final List<Thread> threads;

        public Monitor(List<Thread> threads) {
            this.threads = List.copyOf(threads);
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String state = threads.stream()
                        .map(t -> t.getName() + ": " + t.getState())
                        .collect(Collectors.joining(", "));
                    System.out.println("Threads state=[" + state + "]");
                    Thread.sleep(1_000);
                }
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted. Finishing work.");
            }
        }
    }

    static class Random {
        private final SecureRandom random = new SecureRandom();

        private final int from;
        private final int to;

        Random(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int nextInt() {
            return random.nextInt(from, to);
        }
    }
}
