package Multithreading.Basic;

public class MonitorLockDemo {
    public static void main(String[] args) {
            /*
            * Monitor lock helps to make sure only 1 thread goes inside the synchronized block.
            * */
        MonitorLockDemo monitorLock = new MonitorLockDemo();
        Thread t1 = new Thread(()->{monitorLock.fun1();});
        Thread t2 = new Thread(()->{monitorLock.fun2();});
        t1.start();
        t2.start();
            /*
            * First thread put monitor lock on object and call fun1 method, when monitor lock release by fun1 or fun1 execute completely,
            * then its call fun2 method. This shows the there is only one monitor lock in one object, if there is separate monitor lock
            * for all synchronized method then both fun1 and fun2 print simultaneously.
            * */
    }

    public synchronized void fun1(){
        try {
            System.out.println("Fun1 method");
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }

    public synchronized void fun2(){
        try {
            System.out.println("Fun2 method");
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }
}
