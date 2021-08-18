package dev.evertonsavio.app;

public class JavaMultithreadingApp01 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in a new thread
                System.out.println("We are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
                //throw new RuntimeException("Internal error test");
            }
        });

        thread.setName("New work Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("A critical error happened in thread " + thread.getName() + ".Error: "
                        + throwable.getMessage());
            }
        });

        System.out.println("We are in thread: " + Thread.currentThread().getName() + "before start a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + "after start a new thread");

        Thread.sleep(10000); //Current thread not consumes any cpu
    }
}
