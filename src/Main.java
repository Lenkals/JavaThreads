

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Main {

    public static void doWork() {
        try {
            Thread.sleep(100000);
        }catch(Exception e){
            System.out.println(">> "+e);
        }
    }

    public static void main(String[] args) throws Exception {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPU cores: " + availableProcessors);
        int MAX = 100_000;
        for (int i = 0; i < MAX; i++) {
            //new Thread(Main::doWork).start();
            //Thread.ofVirtual().start(Main::doWork);

               Thread.ofPlatform().start(Main::doWork);

            if (i % 500 == 0) {
                Thread.ofVirtual().start(ThreadAndCoreInfo::getMeThreads);
            }
        }

        System.out.println("Wiat for all Done");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DONE");
        for (int i = 0; i < 2; i++) {
            if (i == 2) {
                System.out.println("got it");
            }
        }
    }
void test(){}



}