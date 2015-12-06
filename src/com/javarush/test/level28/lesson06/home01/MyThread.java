package com.javarush.test.level28.lesson06.home01;


/**
 * Created by nakoryakov on 03.12.15.
 */
public class MyThread extends Thread {
    private static int currentPriority = 1;

    public MyThread() {
        setPeriodicPriority(this);
    }

    public MyThread(Runnable target) {
        super(target);
        setPeriodicPriority(this);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPeriodicPriority(this);
    }

    public MyThread(String name) {
        super(name);
        setPeriodicPriority(this);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPeriodicPriority(this);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPeriodicPriority(this);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPeriodicPriority(this);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPeriodicPriority(this);
    }

    private void setPeriodicPriority(Thread t){
        t.setPriority(1);
        if (currentPriority < Thread.MAX_PRIORITY){
            t.setPriority(currentPriority++);
        }
        else if (currentPriority == Thread.MAX_PRIORITY){
            t.setPriority(10);
            currentPriority = 1;
        }
        if (this.getThreadGroup().getMaxPriority() < currentPriority){
            t.setPriority(this.getThreadGroup().getMaxPriority());
        }
    }
}
