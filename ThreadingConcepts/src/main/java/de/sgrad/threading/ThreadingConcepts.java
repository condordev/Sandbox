package de.sgrad.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadingConcepts {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 100; i++){
                try{
                    System.out.println("i : " + i);
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        });
        t1.start();

        Future<Integer> result = Executors.newFixedThreadPool(1).submit(new MyCallable());
        System.out.println(result.get());

    }


    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int result = 0;
            System.out.println("Name: " + Thread.currentThread().getName());
            for (int i = 0; i < 1000 ; ++i){
                result++;
            }
            return result;
        }
    }

}
