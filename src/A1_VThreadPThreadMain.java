public class A1_VThreadPThreadMain {

    public static void doWork() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(">> " + e);
        }
    }

    public static void main(String[] args) throws Exception {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPU cores: " + availableProcessors);
        int MAX = 70_000;
        for (int i = 0; i < MAX; i++) {
            //new Thread(Main::doWork).start();
            //Thread.ofVirtual().start(Main::doWork);
            Thread.ofVirtual().start(A1_VThreadPThreadMain::doWork);
/*            Thread.ofVirtual().unstarted(() -> {
                System.out.println(" My task--" + Thread.currentThread());
            });*/

            if (i % 500 == 0) {
                ThreadAndCoreInfo.getMeThreads();
            }
        }

        System.out.println("Wiat for all Done");
        try {
            Thread.sleep(50000);
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


}