package org.example.lesson3.homework.database;

/*
Создайте интерфейс, который определяет набор методов для работы с базой данных
(например, сохранение, удаление, получение данных).
Реализуйте этот интерфейс в конкретном классе.
 */
public class DataBaseImpl implements DataBase<Data, Integer> {

    @Override
    public boolean save(Data data) {
        return false;
    }

    @Override
    public boolean remove(Data data) {
        return false;
    }

    @Override
    public Data getData(Integer id) {
        return null;
    }
}
