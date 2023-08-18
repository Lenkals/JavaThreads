import com.tasks.SimpleTask;

import java.util.concurrent.*;

public class RejectThreadPoolTask {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(10, 100, 120, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(300),
                new CustomRejectionHadler());
        while (true) {
            try {

                service.submit(new SimpleTask());
            } catch (RejectedExecutionException re) {
                System.err.println("task rejected" + re.getMessage());
            }

        }
    }

    private static class CustomRejectionHadler implements RejectedExecutionHandler
    {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Custom reject "+r.toString());
        }
    }


}
