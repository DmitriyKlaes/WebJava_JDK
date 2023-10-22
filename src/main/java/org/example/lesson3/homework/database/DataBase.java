package org.example.lesson3.homework.database;

public interface DataBase <T, Tid> {
    boolean save(T data);
    boolean remove(T data);
    T getData(Tid id);
}
