package javatest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {
  public static void main(String[] args) {
    Runnable task=new Runnable(){
        public void run(){
            try {
                Thread.sleep(1000);
                System.out.println("==run down==");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    ExecutorService exc=Executors.newCachedThreadPool();
    try {
        if(exc.submit(task,Boolean.TRUE).get().equals(Boolean.TRUE))
                System.out.println("==finished==");
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    }
    catch (ExecutionException e) {
        e.printStackTrace();
    }
    
    
}
}
