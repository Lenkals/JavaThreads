import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        System.out.println("Task 1 is running.");

        ExecutorService executorService = Executors.
                newFixedThreadPool(2);
        Runnable task1 = () -> {
            int result = 10 / 0;
        };

        Callable<Void> task2 = () -> {
            return null;
        };

        executorService.execute(task1);
        Future<Void> future = executorService.submit(task2);

        try {
            Void result = future.get();
            System.out.println("Task 2 result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        
    }
}
