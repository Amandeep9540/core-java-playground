package Multithreading.locks;

import Multithreading.producerConsumerProblem1.ProducerConsumerProblem;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*In locks for inter-thread communication wait(),notify() method is not available instead wait() == await() , notify() == signal()*/
public class ProducerConsumerProblemByLocks {
    int size = 3;
    Queue<String> buffer = new ArrayDeque<>(size);
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ProducerConsumerProblemByLocks pc = new ProducerConsumerProblemByLocks();
        int dataSize = 10;

        Thread producerThread = new Thread(()->{
            AtomicInteger i = new AtomicInteger(1);
            while(i.getAndIncrement() <= dataSize){ // we are producing 10 sample data
                try {
                    pc.produceData("Data "+i.get());
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println("System is interrupted");
                }
            }
        });
        Thread consumerThread = new Thread(()->{
            AtomicInteger i = new AtomicInteger(1);
            while(i.getAndIncrement() <= dataSize){
                try{
                    System.out.println("Consumed Data is :: "+pc.consumeData());
                }catch (Exception ex){
                    System.out.println("System is interrupted");
                }
            }
        });


        producerThread.start();
        consumerThread.start();
    }

    public void produceData(String data) throws Exception{
        if(buffer.size() == size){
            System.out.println("Buffer size is full --- i am waiting");
            condition.await();
        }
        buffer.add(data);
        System.out.println("Data added in buffer");
        condition.signalAll();
    }

    public String consumeData() throws Exception{
        if(buffer.isEmpty()){
            System.out.println("Buffer is empty i am waiting");
            condition.await();
        }
        String data = buffer.poll();
        System.out.println("Data consume successfully");
        condition.signalAll();
        return data;
    }
}
