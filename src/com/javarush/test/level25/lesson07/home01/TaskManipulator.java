package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    @Override
    public void run() {

    }

    @Override
    public void start(String threadName) {
        try {
            Thread.sleep(50);
            if (!new Thread(this).isInterrupted()){
                System.out.println(threadName);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        new Thread(this).interrupt();
    }
}
