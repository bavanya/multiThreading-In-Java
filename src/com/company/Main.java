package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long number;
        long noOfTimes;
        int noOfThreads;
        int countOfThreads;
        Scanner input = new Scanner(System.in);
        number = input.nextLong();
        noOfTimes = input.nextLong();

        long startTime1 = System.currentTimeMillis();
        Skeleton skeleton = new Skeleton(number,noOfTimes);
        for(long i = 1 ; i <= skeleton.getNoOfTimes() ; i++)
            System.out.println(skeleton.getNumber() + " times " + i + " is " + skeleton.getMultiple(i));
        System.out.println('\n');
        long endTime1 = System.currentTimeMillis();
        float timeTaken1 = (endTime1 - startTime1) / 1000F;
        System.out.println("Time taken for single process is" + timeTaken1 + " seconds");
        //TODO: Add Multithreading.
    }
}
