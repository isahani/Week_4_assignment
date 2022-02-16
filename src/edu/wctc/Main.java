package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner KeyBoard;
    private static PaintCalculator paintCalculator = new PaintCalculator();

    //

    private static void printMenu(){
        System.out.println("1. Add room \n2. Write rooms to file \n3. Read rooms from file \n4. View rooms \n5. Exit \nEnter selection: " );
    }
    private static double promptForDimension (String dimensionName){

        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Enter the room's " + dimensionName + ": ");
        return keyBoard.nextDouble();

    }
    private static void createRoom(){
        double length, width, height;
        length = promptForDimension("length");
        width = promptForDimension("width");
        height = promptForDimension("height");
        paintCalculator.addRoom(length,width,height);
        System.out.println("Room successfully created");
    }
    private static void readFile() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("paint.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        paintCalculator = (PaintCalculator)ois.readObject();
        System.out.println("File read successfully ");
        ois.close();
    }
    private static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("paint.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(paintCalculator);
        System.out.println("File written successfully ");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner keyBoard = new Scanner(System.in);
        int userReply;
        do {
            printMenu();
            userReply = keyBoard.nextInt();
            switch (userReply) {
                case 1:
                    createRoom();
                    break;
                case 2:
                    writeFile();
                    break;
                case 3:
                    readFile();
                    break;
                case 4:
                    System.out.println(paintCalculator.toString());
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
            }

        }
        while (userReply != 5);

    }
}
