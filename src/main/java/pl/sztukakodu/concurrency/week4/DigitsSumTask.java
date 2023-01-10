package pl.sztukakodu.concurrency.week4;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static pl.sztukakodu.concurrency.ThreadUtils.println;

class DigitsSumTask extends RecursiveTask<Integer> {
    private final String number;

    public DigitsSumTask(String number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        println("Computing digits sum for: " + number);
        if (number.length() <= 1) {
            return Integer.valueOf(number);
        }
        // choose split position
        int part = number.length() / 2;
        // split string
        DigitsSumTask leftSum = new DigitsSumTask(number.substring(0, part));
        DigitsSumTask rightSum = new DigitsSumTask(number.substring(part));
        // fork tasks
        ForkJoinTask<Integer> leftTask = leftSum.fork();
        ForkJoinTask<Integer> rightTask = rightSum.fork();
        // join results
        return leftTask.join() + rightTask.join();
    }
}
