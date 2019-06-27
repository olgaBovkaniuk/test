package controlWork2.task1;

import java.util.Scanner;

public class SingletonService {
    private final Scanner scanner = new Scanner(System.in);
    private static SingletonService instance = null;

    public static SingletonService getInstance() {
        if (instance == null) {
            instance = new SingletonService();
        }
        return instance;
    }

    private SingletonService() {
    }

    public void runCreateFileThreads(String stringForArray, int numberOfStringInArray) {
        System.out.println("Please, enter a number of threads: ");
        int numberOfThreads = scanner.nextInt();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new CreateFileRunnable(numberOfStringInArray, i, stringForArray));
            thread.start();
        }
    }
}
