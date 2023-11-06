package org.example.lesson5.homework;

import java.util.Random;

public class Philosophers {

    /*
    Есть пять философов (потоки), которые могут либо обедать либо размышлять.
    Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
    После каждого приема пищи философ должен размышлять
    Не должно возникнуть общей блокировки
    Философы не должны есть больше одного раза подряд
     */
    public static void main(String[] args) {
        Table table = new Table();

        Runnable phil1 = new Philosopher(table, "philosopher1");
        Runnable phil2 = new Philosopher(table, "philosopher2");
        Runnable phil3 = new Philosopher(table, "philosopher3");
        Runnable phil4 = new Philosopher(table, "philosopher4");
        Runnable phil5 = new Philosopher(table, "philosopher5");

        new Thread(phil1, "p1").start();
        new Thread(phil2, "p2").start();
        new Thread(phil3, "p3").start();
        new Thread(phil4, "p4").start();
        new Thread(phil5, "p5").start();
    }
}

class Philosopher implements Runnable {
    Random rnd = new Random();
    String name;
    Table table;
    int countEat = 0;
    boolean hungry = true;

    public Philosopher(Table table, String name) {
        this.table = table;
        this.name = name;
    }

    void startThinking() {
        int timToThinking = rnd.nextInt(500, 4000);
        try {
            System.out.printf("%s ушел размышлять%n", this.name);
            Thread.sleep(timToThinking);
            hungry = !hungry;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (countEat != 3) {
            if (this.hungry) {
                table.startEat(this);
                startThinking();
            }
        }
    }
}

class Table {

    synchronized void startEat(Philosopher ph) {
        if (ph.hungry) {
            try {
                Thread.sleep(500);
                ph.hungry = false;
                ph.countEat += 1;
                System.out.printf("%s поел %d раз %n", ph.name, ph.countEat);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
