package Multithreading.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore lock = new Semaphore(2);
        SemaphoreDemo demoClass = new SemaphoreDemo();
        Thread t1 = new Thread(()->{
            demoClass.printData(lock,"Thread-1");
        });
        Thread t2 = new Thread(()->{
            demoClass.printData(lock,"Thread-2");
        });
        Thread t3 = new Thread(()->{
            demoClass.printData(lock,"Thread-3");
        });
        Thread t4 = new Thread(()->{
            demoClass.printData(lock,"Thread-4");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public void printData(Semaphore lock,String data){
        try{
            lock.acquire();
            System.out.println("Printing data "+data);
            Thread.sleep(100);
            System.out.println("Printed successfully data -- "+data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.release();
        }
    }
}
