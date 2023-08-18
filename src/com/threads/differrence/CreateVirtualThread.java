package com.threads.differrence;

import java.util.concurrent.ForkJoinPool;

public class CreateVirtualThread {
    public static void main(String[] args) throws InterruptedException {
var pThread=Thread.ofPlatform().unstarted(() -> System.out.println(java.lang.Thread.currentThread()));

        pThread.start();
        var vThread=Thread.ofVirtual().unstarted(()-> System.out.println(Thread.currentThread()));
        vThread.start();

        pThread.join();
       vThread.join();
        System.out.println("Class c --> "+vThread.getClass());
var forkJoin= ForkJoinPool.commonPool().submit(()-> System.out.println(Thread.currentThread()));
forkJoin.join();
    };
}
;