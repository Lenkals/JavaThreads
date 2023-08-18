import java.util.concurrent.*;

public class ExecutorCallableExceptionExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            // Simulate an exception
            int result = 10 / 0;
            return result;
        };

        Future<Integer> future = executorService.submit(task);

        try {
Thread.sleep(2);
            // Attempt to retrieve the result (this will throw an ExecutionException)
          String str= future.state().name();
            System.out.println("Result: " + str);
            future.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("Exception caught: " + e.getCause().getMessage());
        }

        executorService.shutdown();
    }
}
