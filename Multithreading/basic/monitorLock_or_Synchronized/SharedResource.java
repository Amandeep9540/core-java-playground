package Multithreading.basic.monitorLock_or_Synchronized;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
        /*In this queue we can add a item one by one, and can get the data directly*/
    public static List<Integer> queue = new ArrayList<>();

    public synchronized boolean produceData(String data){
        try{
            System.out.println("Put a lock on produceData with data --> "+data);
            System.out.println("produceData :: Processing on data --> "+data);
            Thread.sleep(1000); //Simulate we are working
            return true;
        }catch (Exception ex){
            System.out.println("exception in producedata of sharedresource class -- "+ex.getMessage());
        }finally {
            System.out.println("Lock is released on produceData with data --> "+data);
        }
        return false;
    }


    public synchronized boolean produceDataWithExtraChess(String data){
        try{
            System.out.println("Put a lock on produceDataWithExtraChess with data --> "+data);
            System.out.println("produceDataWithExtraChess :: Processing on data --> "+data);
            Thread.sleep(1000); //Simulate we are working
            return true;
        }catch (Exception ex){
            System.out.println("exception in produceDataWithExtraChess of sharedresource class -- "+ex.getMessage());
        }finally {
            System.out.println("Lock is released on produceDataWithExtraChess with data --> "+data);
        }
        return false;
    }
}
