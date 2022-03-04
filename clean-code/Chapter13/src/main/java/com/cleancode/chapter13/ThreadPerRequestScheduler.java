package com.cleancode.chapter13;

public class ThreadPerRequestScheduler implements ClientScheduler{
    public void schedule(final ClientRequestProcessor requestProcessor){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                requestProcessor.process();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
