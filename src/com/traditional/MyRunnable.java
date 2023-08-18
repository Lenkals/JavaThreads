package com.traditional;

public class MyRunnable implements  Runnable{
    public void run(){
        System.out.println("THis is runnable"+Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
        Thread t2= new Thread(()->{
            System.out.println("inline"+Thread.currentThread());
        });
        t2.start();
    }
}
