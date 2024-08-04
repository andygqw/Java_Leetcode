import java.util.concurrent.CompletableFuture;

public class ThreadPool {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        CompletableFuture.supplyAsync(() -> {
                    try {
                        // Simulate a long-running task
                        Thread.sleep(3000);
                        return "Hello";
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }).thenApply(result -> result + ", World!")
                .thenAccept(System.out::println); // Output: Hello, World!

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        // Simulate a long-running task
                        Thread.sleep(4000);
                        return "Hello2";
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }).thenApply(result -> result + ", World2!");

        // Do other work while the async task is running
        System.out.println("Main thread is doing other work.");

        System.out.println(future.join());

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Time Consumed: " + (duration / 1_000_000) + "ms");
        // Keep the main thread alive to see the async result
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}