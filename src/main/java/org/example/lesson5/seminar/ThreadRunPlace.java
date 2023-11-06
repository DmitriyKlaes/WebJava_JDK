package org.example.lesson5.seminar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
3 бегуна должны прийти к старту гонки
Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
Программа должна отсчитать “На старт”, “Внимание”, “Марш”
Программа должна завершиться когда все участники закончат гонку.
 */
public class ThreadRunPlace {

    public static void main(String[] args) throws InterruptedException {
        Race race = new Race();
        Runner runner1 = new Runner(race, "runner1");
        Runner runner2 = new Runner(race, "runner2");
        Runner runner3 = new Runner(race, "runner3");

        new Thread(runner1, "t1").start();
        new Thread(runner2, "t2").start();
        new Thread(runner3, "t3").start();

        while (true) {
            if (runner1.ready && runner2.ready && runner3.ready) {
                System.out.println("На старт!");
                Thread.sleep(500);
                System.out.println("Внимание!!");
                Thread.sleep(500);
                System.out.println("Марш!!!");
                break;
            }
        }
        race.allReady();
    }
}

class Runner implements Runnable {
    String name;
    Race race;
    Random rnd = new Random();
    int distance = 0;
    volatile boolean ready = false;

    public Runner(Race race, String name) {
        this.race = race;
        this.name = name;
    }

    synchronized void setReady() {
        try {
            Thread.sleep(rnd.nextInt(1000));
            System.out.printf("%s is ready!%n", name);
            this.ready = true;
            race.runnerInStart(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        setReady();
        while (distance < 200) {
            int nextDist = rnd.nextInt(10);
            try {
                Thread.sleep(nextDist * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            distance += nextDist;
            System.out.printf("%s преодолел %d метров%n", name, distance);
        }
    }
}

class Race {
    List<Runner> competitors;

    public Race(Runner... runners) {
        this.competitors = new ArrayList<>();
        Collections.addAll(competitors, runners);
    }

    synchronized void allReady() {
        notifyAll();
    }

    synchronized void runnerInStart(Runner runner) {
        if (runner.ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
