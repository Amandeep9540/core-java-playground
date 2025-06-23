package Multithreading.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread demonstrateShareLock1 = new Thread(()->{
            /*In shared lock many thread can get read lock in critical method*/
            ReentrantReadWriteLockDemo reentrantReadWriteLock = new ReentrantReadWriteLockDemo();
            reentrantReadWriteLock.readCriticalData(lock);
        });

        Thread demonstrateShareLock2 = new Thread(()->{
            /*In shared lock many thread can get read lock in critical method*/
            ReentrantReadWriteLockDemo reentrantReadWriteLock = new ReentrantReadWriteLockDemo();
            reentrantReadWriteLock.readCriticalData(lock);

        });

//        demonstrateShareLock1.start();
//        demonstrateShareLock2.start();

        /*If the lock is read then many thread can acquire but if any thread ask for write lock then no lock can provide to other thread.*/

        Thread demonstrateExclusiveLock1 = new Thread(()->{
            try {
                ReentrantReadWriteLockDemo reentrantReadWriteLock = new ReentrantReadWriteLockDemo();
                reentrantReadWriteLock.writeCriticalData(lock);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread demonstrateExclusiveLock2 = new Thread(()->{
            try {
                ReentrantReadWriteLockDemo reentrantReadWriteLock = new ReentrantReadWriteLockDemo();
                reentrantReadWriteLock.writeCriticalData(lock);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        demonstrateExclusiveLock1.start();
        demonstrateExclusiveLock2.start();
        /*If thread wants to acquire write lock then no read/write lock should acquire by other thread.*/
    }

    int criticalData = 10;
    public void readCriticalData(ReentrantReadWriteLock readWriteLock){
        try {
            readWriteLock.readLock().lock();
            System.out.println("Lock acquire to read data by thread --> "+Thread.currentThread().getName());
            Thread.sleep(100);//demonstrate some work to read data
            System.out.println("critical data is --> "+criticalData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void writeCriticalData(ReentrantReadWriteLock readWriteLock){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("acqurie write lock by thread --> "+Thread.currentThread().getName());
            Thread.sleep(100);
            criticalData = 15;
            System.out.println("Data is update by thread --> "+Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

}
