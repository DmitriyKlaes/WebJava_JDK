package org.example.lesson2.developers;

public class DeveloperBack extends Developer implements BackEnder {
    @Override
    public void createServer() {
        System.out.println("Бекенд разработчик сделал сервер");
    }
}
