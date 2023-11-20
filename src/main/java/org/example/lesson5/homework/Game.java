package org.example.lesson5.homework;

import java.util.Random;

public class Game {
    static Random rnd = new Random();
    private int prizeDoor = 0;
    private int openedWrongDoor = 0;
    private int selectedDoorForWin = 0;

    private void fillDoors() {
        this.prizeDoor = rnd.nextInt(0,3);
    }

    private void clearDoors() {
        this.prizeDoor = 0;
        this.openedWrongDoor = 0;
        this.selectedDoorForWin = 0;
    }

    private void openWrongDoor() {
        int choiceOpen;
        do {
            choiceOpen = rnd.nextInt(0, 3);
        } while (choiceOpen == this.prizeDoor || choiceOpen == this.selectedDoorForWin);
        this.openedWrongDoor = choiceOpen;
    }

    private void selectDoorForWin() {
        this.selectedDoorForWin =  rnd.nextInt(0, 3);
    }

    private void changeChoice() {
        this.selectedDoorForWin = 3 - openedWrongDoor - selectedDoorForWin;
    }

    private int checkWin() {
        if(this.selectedDoorForWin == this.prizeDoor) {
            return 1;
        } else {
            return 0;
        }
    }

    public int start(int countGames, boolean switchChoice) {
        int result = 0;
        for (int i = 0; i < countGames; i++) {
            fillDoors();
            selectDoorForWin();
            openWrongDoor();
            if(switchChoice) {
                changeChoice();
            }
            result += checkWin();
            clearDoors();
        }
        return result;
    }

    public static void main(String[] args) {
        Game game = new Game();
        int countGames = 500;

        System.out.println("Игра со сменой выбора:");
        int winsWithChangeChoice = game.start(countGames,true);
        System.out.println("Выйграно " + winsWithChangeChoice);
        System.out.println("Проиграно " + (countGames - winsWithChangeChoice));
        System.out.println("Процент победы составил: " + (((double)(winsWithChangeChoice) / countGames) * 100) + "%");
        System.out.println("-------------------------------");

        System.out.println("Игра без смены выбора:");
        int winsWithoutChangeChoice = game.start(countGames,false);
        System.out.println("Выйграно " + winsWithoutChangeChoice);
        System.out.println("Проиграно " + (countGames - winsWithoutChangeChoice));
        System.out.println("Процент победы составил: " + (((double)(winsWithoutChangeChoice) / countGames) * 100) + "%");
    }
}
