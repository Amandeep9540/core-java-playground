package Multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

/*Reentrant is a locking simple mechanism*/
public class ReentrantLockDemo {
    public static void main(String[] args) {
       ReentrantLock lock = new ReentrantLock();
       Thread t1 = new Thread(()->{
           ReentrantLockDemo demo = new ReentrantLockDemo();
           demo.criticalCode(lock);
       });

        Thread t2 = new Thread(()->{
            ReentrantLockDemo demo = new ReentrantLockDemo();
            demo.criticalCode(lock);
        });

        t1.setName("Thread--1");
        t2.setName("Thread--2");
        t1.start();
        t2.start();
    }

    private void criticalCode(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("lock acquire by thread -> "+Thread.currentThread().getName());
            Thread.sleep(100);
        }catch (Exception exception){
            System.out.println("exception --> "+exception.getMessage());
        }finally {
            System.out.println("lock is releasing");
            lock.unlock();
        }
    }
}
