package com.zeta.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class DataReader implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("Reading data...");
        TimeUnit.SECONDS.sleep(5);
        return "Data reading finished";
    }
}

public class DataProcessor implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("Processing data...");
        TimeUnit.SECONDS.sleep(5);
        return "Data is processed";
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> dataReadFuture = executorService.submit(new DataReader());
        Future<String> dataProcessFuture = executorService.submit(new DataProcessor());

        while (!dataReadFuture.isDone() && !dataProcessFuture.isDone()) {
                System.out.println("Reading and processing not yet finished.");
                // Do some other things that don't depend on these two processes
                // Simulating another task
                TimeUnit.SECONDS.sleep(1);
            }
        System.out.println(dataReadFuture.get());
        System.out.println(dataProcessFuture.get());
    }
}
