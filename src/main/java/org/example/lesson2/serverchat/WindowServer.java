package org.example.lesson2.serverchat;

import javax.swing.*;
import java.awt.*;

public class WindowServer extends JFrame implements SocketThreadListener {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_POSX = 700;
    private static final int WINDOW_POSY = 200;
    ChatServer server = new ChatServer();

    public WindowServer() {

        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        JTextArea field = new JTextArea();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        JPanel panButton = new JPanel(new GridLayout(3, 1));
        add(field);
        panButton.add(btnStart);
        panButton.add(btnStop);

        btnStart.addActionListener(e -> {
            try {
                if (!server.isWork) {
                    field.append(server.start(server.getMessage("Сервер запущен")) + "\n");
                } else {
                    field.append(server.start(server.getMessage("Сервер уже работает")) + "\n");
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            getClientMessage("Я нажимаю на кнопку старт");
        });
        btnStop.addActionListener(e -> {
            if (server.isWork) {
                field.append(server.stop(server.getMessage("Сервер остановлен")) + "\n");
            } else {
                field.append(server.stop(server.getMessage("Сервер не работает")) + "\n");
            }
            getClientMessage("Я нажимаю на кнопку стоп");
        });

        add(panButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void getClientMessage(String message) {
        System.out.println(message);
    }
}
