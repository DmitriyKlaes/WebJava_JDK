package org.example.lesson2.developers;

public class DeveloperFront extends Developer implements FrontEnder {
    @Override
    public void createFront() {
        System.out.println("Фронтэнд разработчик сделал представление с большой кнопкой");
    }
}
