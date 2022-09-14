package com.adam.springproject;

public class MessageTimer implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            try {
                wait(5 * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
