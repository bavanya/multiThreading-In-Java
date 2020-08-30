package com.company;
import java.lang.Math;

public class Skeleton {
    public long number;
    public long noOfTimes;

    public Skeleton(long number, long noOfTimes){
        this.number = number;
        this.noOfTimes = noOfTimes;
    }

    public long getNumber(){
        return number;
    }

    public long getMultiple(long noOfTimes){
        return number*noOfTimes;
    }
    public double getNoOfTimes() {
        return noOfTimes;
    }
}
