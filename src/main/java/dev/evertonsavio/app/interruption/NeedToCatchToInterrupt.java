package dev.evertonsavio.app.interruption;

public class NeedToCatchToInterrupt {

    public static void main(String [] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
    }

    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    //add this rule of thumb, never leave a catch block empty, and use the InterruptedException catch
                    // block to gracefully stop the current thread (by adding some print or cleaning code before
                    // returning from the run method)
                    //add return or interrupt will not work
                    System.out.println("Error");
                    return;
                }
            }
        }
    }
}
