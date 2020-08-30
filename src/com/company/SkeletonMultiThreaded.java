package com.company;

public class SkeletonMultiThreaded implements Runnable{
    public long number;
    public long multiple;

    public SkeletonMultiThreaded(long number, long multiple){
        this.number = number;
        this.multiple = multiple;
    }

    public long getNumber(){
        return number;
    }

    public long getMultiple(){
        return multiple;
    }

    public long getResult(){
        return number*multiple;
    }

    public void run(){
        getResult();
    }
}
