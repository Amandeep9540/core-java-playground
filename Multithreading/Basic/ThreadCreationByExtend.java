package Multithreading.Basic;

public class ThreadCreationByExtend {
    public static void main(String[] args) {
        System.out.println("Main method start and thread name is :: "+Thread.currentThread().getName());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        System.out.println("Main method end and thread name is :: "+Thread.currentThread().getName());
    }
}

class MyThread1 extends Thread{
    public void run(){
        System.out.println("I am inside the run method of MyThread1 and i am executing by thread :: "+Thread.currentThread().getName());
    }
}