import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class B1_Continuation {
// javac --add-exports java.base/jdk.internal.vm=ALL-UNNAMED B1_Continuation.java
// java --add-exports java.base/jdk.internal.vm=ALL-UNNAMED B1_Continuation
    public static void main(String[] args) {
        System.out.println(">>> <<<<<<");
        // --add-exports java.base/jdk.internal.vm=ALL-UNNAMED
        var scope = new ContinuationScope("Hello");
        var continuation = new Continuation(scope, () -> {
            System.out.println("C1 ::" + Thread.currentThread());
            Continuation.yield(scope);
            System.out.println("C2 ::" + Thread.currentThread());
            Continuation.yield(scope);
            System.out.println("C3 ::" + Thread.currentThread());
        });
        System.out.println("Start");
        continuation.run();
        System.out.println("Cameback");
        continuation.run();
        System.out.println("Cameback again");
        continuation.run();
        System.out.println("Done");

    }
}
