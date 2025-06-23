package Multithreading.producerConsumerProblem1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerProblem {
    Queue<String> queue;
    int capacity;
    ProducerConsumerProblem(int capacity){
        queue = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }
    public static void main(String[] args) {
        ProducerConsumerProblem pc = new ProducerConsumerProblem(7);
        int dataSize = 10;

        Thread producerThread = new Thread(()->{
            AtomicInteger i = new AtomicInteger(1);
            while(i.getAndIncrement() <= dataSize){ // we are producing 10 sample data
                try {
                    pc.produceData("Data "+i.get());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
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

    /*
    * Both produceData,consumeData is in same class and one monitor lock will use, means only one thread at a time goes inside these method
    * */

    public synchronized void produceData(String data) throws InterruptedException {
        while(queue.size() == capacity){ // we can use if, but spurious wakeups condition can occur
            System.out.println("Queue size is full and its waiting to consume some data by consumer");
            wait(); // wait until anyone notify and release the monitor lock
        }
        queue.add(data);
        notify(); // if consumer thread is in waiting state
    }

    public synchronized String consumeData() throws InterruptedException {
        while(queue.isEmpty()){
            System.out.println("Thread is empty and its waiting to insert some data by producer");
            wait();
        }
        String item =  queue.poll();
        notify(); // if producer thread is in waiting state
        return item;
    }
}
