package org.example.chat;

/*
Задача: Создать окно клиента чата. Окно должно содержать JtextField
для ввода логина, пароля, IP-адреса сервера, порта подключения
к серверу, область ввода сообщений, JTextArea область просмотра
сообщений чата и JButton подключения к серверу и отправки сообщения
в чат. Желательно сразу сгруппировать компоненты, относящиеся
к серверу сгруппировать на JPanel сверху экрана, а компоненты,
относящиеся к отправке сообщения – на JPanel снизу
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatWindow extends JFrame {
    Server server = new ChatServer();
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_POSX = 700;
    private static final int WINDOW_POSY = 200;

    ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat 5000");
        setResizable(false);

        JPanel panSet = new JPanel(new GridLayout(5, 1));
        JTextField loginField = new JTextField("Login");
        loginField.setToolTipText("Enter your login");
        JTextField passField = new JTextField("pass");
        passField.setToolTipText("Enter your pass");
        JTextField ipField = new JTextField("ip");
        ipField.setToolTipText("Enter your ip");
        JTextField portField = new JTextField("port");
        portField.setToolTipText("Enter your port");
        panSet.add(loginField);
        panSet.add(passField);
        panSet.add(ipField);
        panSet.add(portField);
        add(panSet, BorderLayout.NORTH);

        JPanel panConnected = new JPanel(new GridLayout(1, 3));
        JLabel ip = new JLabel();
        JLabel port = new JLabel();
        JButton btnDisconnect = new JButton("Disconnect");
        panConnected.add(ip);
        panConnected.add(port);
        panConnected.add(btnDisconnect);

        for (Component component : panSet.getComponents()) {
            if (component instanceof JTextField) {
                String value = ((JTextField) component).getText();
                component.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (((JTextField) component).getText().equals(value)) {
                            ((JTextField) component).setText("");
                        }
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        if (((JTextField) component).getText().isEmpty()) {
                            ((JTextField) component).setText(value);
                        }
                    }
                });
            }
        }

        JPanel panMid = new JPanel(new GridLayout(1, 3));
        JTextArea fieldChat = new JTextArea();
        fieldChat.setEditable(false);
        fieldChat.setLineWrap(true);
        fieldChat.setWrapStyleWord(true);
        JList<String> listUsers = new JList<>();
        String users[] = {"Dima", "Katya", "Sasha", "Vasya", "Ignat"};
        listUsers.setListData(users);
        panMid.add(fieldChat);
        JScrollPane scroll = new JScrollPane(fieldChat);
        panMid.add(scroll);
        panMid.add(listUsers);
        add(panMid);

        JButton btnConnect = new JButton("Connect");
        panSet.add(btnConnect);

        JPanel panChat = new JPanel(new GridLayout(2, 1));
        JTextField fieldMessage = new JTextField("Message");
        fieldMessage.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fieldMessage.getText().equals("Message")) {
                    fieldMessage.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (fieldMessage.getText().isEmpty()) {
                    fieldMessage.setText("Message");
                }
            }
        });
        JButton btnSend = new JButton("Send");
        btnSend.setEnabled(false);

        fieldMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !fieldChat.getText().equals("Message") && btnSend.isEnabled()) {
                    fieldChat.append(fieldMessage.getText() + String.format("%n"));
                    fieldMessage.setText("");
                }
            }
        });
        btnSend.addActionListener(e -> {
            fieldChat.append(fieldMessage.getText() + String.format("%n"));
            fieldMessage.setText("");
        });
        btnConnect.addActionListener(e -> {
            fieldChat.setText(server.restoreChat());
            remove(panSet);
            add(panConnected, BorderLayout.NORTH);
            btnSend.setEnabled(true);
            ip.setText("IP:" + ipField.getText());
            port.setText("Port:" + portField.getText());
            panConnected.revalidate();
            repaint();
        });
        btnDisconnect.addActionListener(e -> {
            server.saveChat(fieldChat.getText());
            remove(panConnected);
            add(panSet, BorderLayout.NORTH);
            btnSend.setEnabled(false);
            panSet.revalidate();
            repaint();
        });

        panChat.add(fieldMessage);
        panChat.add(btnSend);
        add(panChat, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                server.saveChat(fieldChat.getText());
            }
        });

        setVisible(true);
        getContentPane().requestFocusInWindow();
        panChat.requestFocus();
    }
}