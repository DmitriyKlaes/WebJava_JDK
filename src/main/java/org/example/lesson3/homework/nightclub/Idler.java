package org.example.lesson3.homework.nightclub;

public class Idler implements Person{
    @Override
    public void doWork() {
        System.out.println("I don`t wont to work!");
    }

    @Override
    public void haveRest() {
        System.out.println("Party Hard!");
    }
}