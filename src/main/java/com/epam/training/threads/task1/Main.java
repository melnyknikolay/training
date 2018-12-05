package com.epam.training.threads.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
       final AtomicInteger counter = new AtomicInteger(11);

       new Thread(() -> {
            while (counter.get() > 0){
                try {
                    System.out.println(counter.decrementAndGet());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bomb!!!");
        }).start();
    }
}
