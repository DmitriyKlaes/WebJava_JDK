package org.example.lesson2.developers;

public class DeveloperFull extends Developer implements FullStack {
    @Override
    public void createServer() {
        System.out.println("Фуллстак разработчик сделал сервер");
    }

    @Override
    public void createFront() {
        System.out.println("Фуллстак разработчик сделал фронтэед представление");
    }
}
