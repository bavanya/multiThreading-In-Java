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
        for( long i = 1 ; i <= skeleton.getNoOfTimes() ; i++ )
            System.out.println(skeleton.getNumber() + " times " + i + " is " + skeleton.getMultiple(i));
        System.out.println('\n');
        long endTime1 = System.currentTimeMillis();
        float timeTaken1 = (endTime1 - startTime1) / 1000F;
        System.out.println("Time taken for single process is" + timeTaken1 + " seconds");

        number = input.nextLong();
        noOfTimes = input.nextLong();
        noOfThreads = input.nextInt();
        countOfThreads = noOfThreads - 1;
        SkeletonMultiThreaded[] skeletonMultiThreaded = new SkeletonMultiThreaded[noOfThreads];
        Thread[] t = new Thread[noOfThreads];

        long startTime2 = System.currentTimeMillis();
        for( long i = 1 ; i <= noOfTimes ; i++ ){
            if(countOfThreads != -1){
                skeletonMultiThreaded[noOfThreads - countOfThreads - 1] = new SkeletonMultiThreaded(number,i);
                countOfThreads--;
            }
            if(countOfThreads == -1) {
                for( int j = 0; j < noOfThreads ; j++){
                    t[j] = new Thread(skeletonMultiThreaded[j]);
                    t[j].start();
                }
                for( int j = 0; j < noOfThreads ; j++ ){
                    try {
                        t[j].join();
                        System.out.println(skeletonMultiThreaded[j].getNumber() + " times " + skeletonMultiThreaded[j].getMultiple()+ " is " + skeletonMultiThreaded[j].getResult());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countOfThreads = noOfThreads - 1;
            }
        }

        if( countOfThreads != noOfThreads - 1 ){
            for( int j = 0; j <noOfThreads - countOfThreads-1 ; j++ ){
                t[j] = new Thread(skeletonMultiThreaded[j]);
                t[j].start();
            }
            for( int j = 0; j < noOfThreads - countOfThreads - 1 ; j++ ){
                try {
                    t[j].join();
                    System.out.println(skeletonMultiThreaded[j].getNumber() + " times " + skeletonMultiThreaded[j].getMultiple()+ " is " + skeletonMultiThreaded[j].getResult());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime2 = System.currentTimeMillis();

        float timeTaken2 = (endTime2 - startTime2) / 1000F;
        System.out.println("Time taken for multiThreaded process is" + timeTaken2 + " seconds");
    }
}
