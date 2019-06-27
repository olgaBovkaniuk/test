package controlWork2.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class PlayerGeneratorTaskCallable implements Callable<String> {
    private final Random random = new Random();
    private int fileNameCounter;
    private int listLength;
    private int ageFrom;
    private int ageTo;

    public PlayerGeneratorTaskCallable(int fileNameCounter, int listLength, int ageFrom, int ageTo) {
        this.fileNameCounter = fileNameCounter;
        this.listLength = listLength;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
    }

    public String writeToFile(List<Player> playerList) {
        String fileName = "listOfPlayers_" + fileNameCounter + ".txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Player player : playerList) {
                bufferedWriter.write(player.toString());
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileName;
    }

    private List<Player> generateListOfPlayers() {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            playerList.add(new Player(
                    String.valueOf(i),
                    random.nextInt(ageTo - ageFrom + 1) + ageFrom,
                    random.nextBoolean()
            ));
        }
        return playerList;
    }

    @Override
    public String call() throws Exception {
        return writeToFile(generateListOfPlayers());
    }
}
