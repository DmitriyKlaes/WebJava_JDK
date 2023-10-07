package org.example.chat;

public interface Server {
    void saveChat(String text);
    String restoreChat();
}
