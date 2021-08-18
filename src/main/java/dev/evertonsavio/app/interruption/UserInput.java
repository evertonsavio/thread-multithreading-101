package dev.evertonsavio.app.interruption;

import java.io.IOException;

public class UserInput {

    public static void main(String [] args) {
        Thread thread = new Thread(new WaitingForUserInput());
        thread.setName("InputWaitingThread");

        System.out.println(Thread.currentThread().getName());
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }

    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if(input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            };
        }
    }

}
