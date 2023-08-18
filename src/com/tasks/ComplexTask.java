package com.tasks;

import java.util.concurrent.Callable;

public class ComplexTask implements Callable<Void> {
    @Override
    public Void call() throws Exception {
        System.out.println("This is complex task:"+Thread.currentThread());
        return null;
    }
}
