package com.javarush.test.level24.lesson02.home01;

/**
 * Created by nakoryakov on 29.07.15.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public SelfInterfaceMarkerImpl() {
    }
    public void printMyName(){
        System.out.println(getClass().getSimpleName());
    }
    public void printCurrentTime(){
        System.out.println(System.currentTimeMillis());
    }
}
