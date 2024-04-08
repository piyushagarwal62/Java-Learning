package com.codebypiyush.java7.forkjoinpool.example4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private int[] arr;

    private static final int THRESHOLD = 20;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
              .stream()
              .mapToInt(ForkJoinTask::join)
              .sum();
        } else {
            return processing(arr);
        }
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        return dividedTasks;
    }

    private Integer processing(int[] arr) {
        System.out.println(" "
                + Thread.currentThread().getName());
        return Arrays.stream(arr)
          .filter(a -> a > 10 && a < 90)
          .map(a -> a + 10)
          .sum();
    }

    public static void main(String[] args) {
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

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);
        new ForkJoinPool().execute(customRecursiveTask);
        int result = customRecursiveTask.join();
        System.out.println("Sum: " + result);

    }
}