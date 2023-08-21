import java.nio.file.Files;
import java.nio.file.Paths;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class A2_VThreadPThreadIOOperation {
    public static void fetch(int index, String filePath) {
        try {
            System.out.println("Entering : " + index + " " + Thread.currentThread());
            // I/O operation
            var count = Files.lines(Paths.get(filePath)).count();
            System.out.println(count);
            System.out.println("Exiting : " + index + " " + Thread.currentThread());
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Catch : " + index + " " + Thread.currentThread());
        } finally {
            System.out.println("Finally : " + index + " " + Thread.currentThread());
        }
    }

    public static void main(String[] args) {

        int MAX = 500;
        for (int i = 0; i < MAX; i++) {
            int index = i;
           var pThread= Thread.ofPlatform().unstarted(
                    () -> fetch(index, "C:\\Dev\\Workspace\\JavaThreads\\src\\A2_VThreadPThreadIOOperation.java"));
            pThread.start();
        }

        System.out.println("Done");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}