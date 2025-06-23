package Multithreading.basic;

public class DaemonJoinPriorityMethods {
    public static void main(String[] args) {
        //demonstrateDaemonThread();
        //demonstrateThreadPriority();
        demonstrateJoinMethod();
    }

    private static void demonstrateDaemonThread() {
        Thread mainThread = new Thread(()->{
            try {
                Thread.sleep(100);
                System.out.println("Acting as a main thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread demonThread = new Thread(()->{
            try {
                while(true){
                    Thread.sleep(10);
                    System.out.println("demon is working ");
                }
            }catch (Exception ex){

            }
        });
        demonThread.setDaemon(true);

        mainThread.start();
        demonThread.start();
        /*Demon thread is alive until other non demon thread alive.*/
    }

    private static void demonstrateThreadPriority() {
        Thread priorityThread = new Thread(()->{
            System.out.println("I am in hurry");
        });

        Thread normalThread = new Thread(()->{
            System.out.println("Not in hurry");
        });
        priorityThread.setPriority(10);

        priorityThread.start();
        normalThread.start();
        /*A thread with higher priority is more likely to be selected by the JVM scheduler to run, but it's not guaranteed that it will always execute first*/
    }

    private static void demonstrateJoinMethod() {
        Thread youNeedMe = new Thread(()->{
            try {
                System.out.println("dependent thread needs me");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("exception occur in youNeedMe thread "+e.getMessage());
            }
        });

        Thread dependentThread = new Thread(()->{
            try {
                System.out.println("i want above thread to work");
                youNeedMe.join();
                System.out.println("aww! finally above thread works complete");
            } catch (Exception e) {
                System.out.println("exception occur in dependentThread "+e.getMessage());
            }
        });
        dependentThread.start();
        youNeedMe.start();
                /*Using join method one thread can wait for second thred to complete their execution.*/
    }

}
