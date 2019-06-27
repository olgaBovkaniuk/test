package controlWork2.task1;

import java.io.*;
import java.util.Random;

public class CreateFileRunnable implements Runnable {
    private final Random random = new Random();
    private String stringForArray; //"In any programming language arrays are used that are convenient for working with a large number of the same type of data";
    private int numberOfStringInArray;
    private int fileNameCounter;

    public CreateFileRunnable(int numberOfStringInArray, int fileNameCounter, String stringForArray) {
        this.numberOfStringInArray = numberOfStringInArray;
        this.fileNameCounter = fileNameCounter;
        this.stringForArray = stringForArray;
    }

    public String writeToFile(String[] arrayOfFourString) {
        String fileName = "arrayOfStings_" + fileNameCounter + ".txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : arrayOfFourString) {
                stringBuilder.append(string);
                stringBuilder.append(" ");
            }
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileName;
    }

    public void readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String[] getArrayOfFourString() {
        String[] strings = stringForArray.split(" ");
        String[] arrayOfFourString = new String[numberOfStringInArray];
        for (int i = 0; i < numberOfStringInArray; i++) {
            arrayOfFourString[i] = strings[random.nextInt(strings.length)];
        }
        return arrayOfFourString;
    }

    @Override
    public void run() {
        readFromFile(writeToFile(getArrayOfFourString()));
    }
}
