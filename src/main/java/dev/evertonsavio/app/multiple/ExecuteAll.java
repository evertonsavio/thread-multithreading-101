package dev.evertonsavio.app.multiple;

import java.util.ArrayList;
import java.util.List;

public class ExecuteAll {

    public static void main(String[] args) {

        List<Runnable> runnableList = new ArrayList<>();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        runnableList.add(task1);
        runnableList.add(task2);

        MultiExecutor multiExecutor = new MultiExecutor(runnableList);
        multiExecutor.executeAll();
    }

    public static class Task1 implements Runnable{

        @Override
        public void run() {

            System.out.println("TASK 1");

        }
    }

    public static class Task2 implements Runnable{

        @Override
        public void run() {

            System.out.println("TASK 2");

        }
    }
}
