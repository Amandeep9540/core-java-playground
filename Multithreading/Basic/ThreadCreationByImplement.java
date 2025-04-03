package Multithreading.Basic;

public class ThreadCreationByImplement {
    public static void main(String[] args) {
        System.out.println("Main method start and thread name is :: "+Thread.currentThread().getName());
        Thread thread2 = new Thread(new MyThread2());
        thread2.start();
        System.out.println("Main method end and thread name is :: "+Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable{
    public void run(){
        System.out.println("I am inside the run method of MyThread2 and i am executing by thread :: "+Thread.currentThread().getName());
    }
}
