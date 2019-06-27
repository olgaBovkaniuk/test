package controlWork2.task2;

import controlWork2.task2.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerReaderTaskCallable implements Callable<List<Player>> {
    private String fileName;

    public PlayerReaderTaskCallable(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readFromFile() {
        List<String> playerStringList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String string = bufferedReader.readLine();
            while (string != null) {
                playerStringList.add(string);
                string = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return playerStringList;
    }

    public List<Player> getPlayersList(List<String> playerStringList) {
        List<Player> playerList = new ArrayList<>();
        for (String string : playerStringList) {
            String[] playerValues = string.split(" ");
            Player player = new Player(playerValues[0], Integer.valueOf(playerValues[1]), Boolean.valueOf(playerValues[2]));
            playerList.add(player);
        }
        return playerList;
    }

    public List<Player> getActivePlayersList(List<Player> playerList) {
        List<Player> activePlayersList = new ArrayList<>();
        for (Player player : playerList) {
            if (player.getAge() > 25 && player.getAge() < 30 && player.isActive()) {
                activePlayersList.add(player);
            }
        }
        return activePlayersList;
    }

    @Override
    public List<Player> call() throws Exception {
        return getActivePlayersList(getPlayersList(readFromFile()));
    }
}
