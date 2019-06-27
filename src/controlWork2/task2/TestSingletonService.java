package controlWork2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestSingletonService {
    private static TestSingletonService instance = null;

    public static TestSingletonService getInstance() {
        if (instance == null) {
            instance = new TestSingletonService();
        }
        return instance;
    }

    private TestSingletonService() {
    }

    public List<String> runPlayerGeneratorTask(int numberOfThreads, int listLength, int ageFrom, int ageTo) {
        List<String> stringFileNameList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Future<String> future = executorService.submit(new PlayerGeneratorTaskCallable(i, listLength, ageFrom, ageTo));
            futureList.add(future);
        }
        for (Future<String> future : futureList) {
            try {
                stringFileNameList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
        executorService.shutdown();
        return stringFileNameList;
    }

    public List<Player> runPlayerReaderTask(int numberOfThreads, List<String> stringFileNameList) {
        List<List<Player>> listOfPlayers = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<List<Player>>> futureList = new ArrayList<>();
        for (String string : stringFileNameList) {
            Future<List<Player>> future = executorService.submit(new PlayerReaderTaskCallable(string));
            futureList.add(future);
        }
        for (Future<List<Player>> future : futureList) {
            try {
                listOfPlayers.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Player> playerList = new ArrayList<>();
        for (List<Player> listOfPlayer : listOfPlayers) {
            playerList.addAll(listOfPlayer);
        }
        executorService.shutdown();
        return playerList;
    }
}
