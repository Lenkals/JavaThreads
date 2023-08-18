package com.tasks;

public class SimpleTask implements Runnable{
    @Override
    public void run() {
        System.out.println("This is simple task"+Thread.currentThread());
    }
}

