import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadAndCoreInfo {
    static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    public static void main(String[] args) {
        // Get the thread management bean


        // Get the number of live threads and peak thread count


        // Get the available processors (CPU cores)
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPU cores: " + availableProcessors);
        ThreadAndCoreInfo.getMeThreads();
    }
    public static void getMeThreads(){
        int liveThreads = threadMXBean.getThreadCount();
        int peakThreads = threadMXBean.getPeakThreadCount();

        System.out.println("Number of live threads: " + liveThreads);
        System.out.println("Peak thread count: " + peakThreads);
    }

}
