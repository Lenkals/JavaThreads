package com.traditional;

public class MyThread extends Thread{
    public void run(){
        System.out.println("You are in MyThread :: "+Thread.currentThread());
    }

    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
    }
}
