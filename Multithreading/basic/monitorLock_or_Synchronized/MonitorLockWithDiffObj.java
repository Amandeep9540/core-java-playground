package Multithreading.basic.monitorLock_or_Synchronized;

public class MonitorLockWithDiffObj {
    public static void main(String[] args) {
            /*
            * In this method we have created two object of sharedResource class and try to add data...
            * Expectation :: because we have put the synchronized keyword on producedata method then only one thread enter at a time.
            * */

        SharedResource sh1 = new SharedResource();
        Thread t1 = new Thread(()->{
            sh1.produceData("data-- 1");
        });


        SharedResource sh2 = new SharedResource();
        Thread t2 = new Thread(()->{
            sh2.produceData("data-- 2");
        });

        t1.start();
        t2.start();

        /*
        *In Reality-- both thread enter at a same time on producedata method, because in synchronized method put a monitor lock on a method
        * every object has its own monitor lock, so if we use same object then only one thread will enter, but here we are using the different.
        * Every object has its own monitor lock and its only one.
        * */

        Thread t3 = new Thread(()-> {
            sh1.produceData("without chess 1 ");// Expectation :: both will enter in method at same time, because both are different method
        });

        Thread t4 = new Thread(()->{
            sh1.produceDataWithExtraChess("with chess 1");
        });
        t3.start();
        t4.start();

        /*In Reality -- they can't enter at same time, because both are using the same monitor lock and first whichever thread execute it puts the monitor lock and when
        *  this thread release the lock then another thread put the lock and execute method */
    }
}
