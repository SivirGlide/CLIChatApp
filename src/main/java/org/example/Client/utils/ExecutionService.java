package org.example.Client.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutionService {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void execute(Runnable task) {
        executor.execute(task);
    }
}
