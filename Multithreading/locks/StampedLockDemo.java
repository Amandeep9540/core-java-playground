package Multithreading.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    /*Stamped is optimistic type of locking*/
    public static void main(String[] args) {
        StampedLock lock =  new StampedLock();
        Thread t1 = new Thread(()->{
            StampedLockDemo stampedLockDemo = new StampedLockDemo();
            stampedLockDemo.processCriticalData(lock);
        });

        Thread t2 = new Thread(()->{
            StampedLockDemo stampedLockDemo = new StampedLockDemo();
            stampedLockDemo.processCriticalData(lock);
        });

        t1.start();
        t2.start();
    }

    private int criticalData = 10;
    public void processCriticalData(StampedLock lock){

        try {
            long version =  lock.tryOptimisticRead();
            System.out.println("start processing for thread -- "+Thread.currentThread().getName());
            int data = readCriticalData();
            Thread.sleep(100);
            if(lock.validate(version)){
                System.out.println("no other thread update the value so i am updating");
                updateCriticalData(data+10);
            }else{
                System.out.println("Other thread has updated the value i need to rollback and again need to do");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCriticalData(int data){
        criticalData = data;
    }
    public int readCriticalData(){
        return criticalData;
    }
}
