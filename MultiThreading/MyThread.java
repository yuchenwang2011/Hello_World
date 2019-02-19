package Intro;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.print("thread is running");
    }
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
