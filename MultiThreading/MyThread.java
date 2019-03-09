package Intro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("thread is running: " + Thread.currentThread().getName());
    }
    public static void main(String[] args){
        Thread myThread = new MyThread();
        myThread.start();

        Thread myThread2 = new MyThread();
        myThread2.start();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new MyThread());
    }
}


Multithreading interview questions:
https://www.youtube.com/watch?v=rSHXanQaSQs
