package org.example.lesson4.homework;

import java.time.LocalDateTime;

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
public class Employee {
    private int id;
    private String phone;
    private String name;
    private LocalDateTime hireDate;

    private static int idE = 0;

    public Employee(String phone, String name, LocalDateTime hireDate) {
        this.id = ++idE;
        this.phone = phone;
        this.name = name;
        this.hireDate = hireDate;
    }

    public int getWorkingYears() {
        int start = hireDate.getYear();
        int now = LocalDateTime.now().getYear();
        return now - start;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
