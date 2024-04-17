package com.codebypiyush.java7.forkjoinpool.example2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SearchTask extends RecursiveTask<Integer> {

    private int[] arr;
    private int start;
    private int end;
    private int element;
    private int chunkSize = 10;
    ForkJoinPool pool = ForkJoinPool.commonPool();

    public SearchTask(int[] arr, int element) {
        this.arr = arr;
        this.start = 0;
        this.end = arr.length;
        this.element = element;
    }

    public SearchTask(int[] arr, int start, int end, int element) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.element = element;
    }

    @Override
    protected Integer compute() {

        int length = end - start;

        int occurance = 0;
        if (length <= chunkSize) {
            for (int i = start; i < end; i++) {
                if (arr[i] == element) {
                    occurance++;
                }
            }
            return occurance;
        }

        int mid = start + length / 2;
        SearchTask taskFirst = new SearchTask(arr, start, mid, element);
        SearchTask taskSecond = new SearchTask(arr, mid, end, element);

        taskFirst.fork();
        taskSecond.fork();
        return taskFirst.join() + taskSecond.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        SearchTask searchTask = getSearchTask();

        //this is a synchronous or blocking call. Calling thread waits until
        //it returns a value
        int x = pool.invoke(searchTask);
        System.out.printf("******************************************\n");
        System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
        System.out.printf("Main: Active Threads: %d\n",
                pool.getActiveThreadCount());
        System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
        System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
        System.out.printf("******************************************\n");
        System.out.println(x);
    }

    private static SearchTask getSearchTask() {
        int[] arr = {
                12, 56, 78, 234, 567, 890, 23, 456, 789, 345,
                678, 901, 34, 678, 123, 456, 789, 234, 567, 890,
                12, 56, 78, 234, 567, 890, 23, 456, 789, 345,
                678, 901, 34, 678, 123, 456, 789, 234, 567, 890,
                12, 56, 78, 234, 567, 890, 23, 456, 789, 345,
                678, 901, 34, 678, 123, 456, 789, 234, 567, 890,
                12, 56, 78, 234, 567, 890, 23, 456, 789, 345,
                678, 901, 34, 678, 123, 456, 789, 234, 567, 890,
                12, 56, 78, 234, 567, 890, 23, 456, 789, 345,
                678, 901, 34, 678, 123, 456, 789, 234, 567, 890
        };

        SearchTask searchTask = new SearchTask(arr, 123);
        return searchTask;
    }
}