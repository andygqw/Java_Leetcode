import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

//        CompletableFuture.supplyAsync(() -> {
//                    try {
//                        // Simulate a long-running task
//                        Thread.sleep(3000);
//                        return "Hello";
//                    } catch (InterruptedException e) {
//                        throw new IllegalStateException(e);
//                    }
//                }).thenApply(result -> result + ", World!")
//                .thenAccept(System.out::println); // Output: Hello, World!
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//                    try {
//                        // Simulate a long-running task
//                        Thread.sleep(4000);
//                        return "Hello2";
//                    } catch (InterruptedException e) {
//                        throw new IllegalStateException(e);
//                    }
//                }).thenApply(result -> result + ", World2!");

        Runnable task = () -> {
            try{
                Thread.sleep(2000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Task executed by: " + Thread.currentThread().getName());
        };

        // Create a fixed thread pool executor
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Run the task asynchronously several times
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            CompletableFuture.runAsync(task, executorService)
//                    .thenRun(() -> System.out.println("Task " + (finalI + 1) + " completed."));
//        }

        CompletableFuture<Void>[] futures = new CompletableFuture[5];

        // Start several CompletableFuture tasks in a loop
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            futures[i] = CompletableFuture.runAsync(task, executorService)
                    .thenRun(() -> System.out.println("Task " + (finalI + 1) + " completed."));
        }

        // Combine all CompletableFutures
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

//        // Join all tasks to ensure main thread waits for their completion
//        allFutures.join();

//
//        // Do other work while the async task is running
//        System.out.println("Main thread is doing other work.");
//
        // Shutdown the executor service
        executorService.shutdown();
        try{

            executorService.awaitTermination(3, TimeUnit.SECONDS);
        }
        catch(InterruptedException e){

            e.printStackTrace();
        }

//        for(int i = 0; i < 5; i++){
//
//            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//
//                try{
//
//                    Thread.sleep(2000);
//                    System.out.println("Hello from thread " + Thread.currentThread().getName());
//                }
//                catch (InterruptedException e){
//
//                    throw new IllegalStateException(e);
//                }
//            });
//        }

        // Do other work while the async task is running
        System.out.println("Main thread is doing other work.");

        //System.out.println(future.join());

//        try{
//
//            Thread.sleep(10000);
//        }
//        catch (Exception e){
//
//            e.printStackTrace();
//        }

//        // Join all tasks to ensure main thread waits for their completion
//        allFutures.join();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Time Consumed: " + (duration / 1_000_000) + "ms");
        // Keep the main thread alive to see the async result
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Main thread finished: " + Thread.currentThread().getName());
    }
}