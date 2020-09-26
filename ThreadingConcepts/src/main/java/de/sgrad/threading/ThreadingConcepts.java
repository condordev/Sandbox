package de.sgrad.threading;

public class ThreadingConcepts {
    public static void main(String[] args){
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
    }
}
