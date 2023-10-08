package org.example.lesson2.serverchat;

public class ChatServer implements ServerListener, SocketThreadListener, ServerSocketThreadListener {

    public boolean isWork = false;

    public ChatServer() {
    }

    public String start(String message) throws InterruptedException {
        if (!this.isWork) {
            Thread.sleep(500);
        }
        this.isWork = true;
        getClientMessage("Пришла команда на сервер от клиента: START");
        logSocketMessage();
        return message;
    }

    public String stop(String message) {
        this.isWork = false;
        getClientMessage("Пришла команда на сервер от клиента: STOP");
        logSocketMessage();
        return message;
    }

    public boolean isWork() {
        return this.isWork;
    }

    @Override
    public String getMessage(String message) {
        return message;
    }

    @Override
    public void logSocketMessage() {
        System.out.println("Сервер сокет работает");
    }

    @Override
    public void getClientMessage(String message) {
        System.out.println(message);
    }
}
