package com.epam.training.threads.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        new Thread(new Counter(counter)).start();
    }

    private static class Counter implements Runnable{

        private final AtomicInteger count;

        private Counter(AtomicInteger count) {
            this.count = count;
        }

        @Override
        public void run() {
            while (count.get() < 1000000){
                count.incrementAndGet();
            }
        }
    }

    private static class Printer implements Runnable{
        private final AtomicInteger count;

        private Printer(AtomicInteger count) {
            this.count = count;
        }

        @Override
        public void run() {
            System.out.println(count.get());
        }
    }
}
