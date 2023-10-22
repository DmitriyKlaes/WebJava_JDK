package org.example.lesson4.homework;

import java.time.LocalDateTime;
import java.time.Month;

/*
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников -
каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class Main {
    public static void main(String[] args) {
        NoteEmployee note = new NoteEmployee();
        Employee emp1 = new Employee("353451234", "user1", LocalDateTime.of(2018, Month.APRIL, 5, 5, 5));
        Employee emp2 = new Employee("3436435634", "user2", LocalDateTime.of(2020, Month.APRIL, 5, 5, 5));
        Employee emp3 = new Employee("3534214", "user3", LocalDateTime.of(2020, Month.APRIL, 5, 5, 5));
        Employee emp4 = new Employee("35324216234", "user3", LocalDateTime.of(2021, Month.APRIL, 5, 5, 5));
        Employee emp5 = new Employee("351234", "user5", LocalDateTime.of(2022, Month.APRIL, 5, 5, 5));
        note.add(emp1);
        note.add(emp2);
        note.add(emp3);
        note.add(emp4);
        note.add(emp5);

        System.out.println(note.getEmployees(2));
        System.out.println(note.getPhone("user3"));
        System.out.println(note.getEmployee(2));

    }

}
