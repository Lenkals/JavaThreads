import com.tasks.ComplexTask;
import com.tasks.SimpleTask;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i=0; i<22000; i++) {
            executorService.execute(new SimpleTask());
            //executorService2.execute(ThreadAndCoreInfo::getMeThreads);
        }
        Future <Void>f= executorService.submit(new ComplexTask());
        Void unused = f.get();
        System.out.println("Void -->"+unused);
        //  executorService.awaitTermination(1);
      //  executorService.shutdown();
    }

}
