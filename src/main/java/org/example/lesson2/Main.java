package org.example.lesson2;

/*
1.
было описано окно сервера приложения, содержащее две кнопки (старт и стоп)
и текстовое поле журнала. Необходимо вынести логику работы сервера
в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки и
журналирования сообщений от сервера.
Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
«получить сообщение», вызывать его с одной стороны, и реализовать с другой.

Создать простейшее окно управления сервером (по сути, любым),
содержащее две кнопки (JButton) – запустить сервер и остановить сервер.
Кнопки должны просто логировать нажатие (имитировать запуск и остановку сервера, соответственно)
и выставлять внутри интерфейса соответствующее булево isServerWorking

2.
Создать интерфейсы ServerSocketThreadListener и SocketThreadListener,
содержащие методы, соответствующие событиям сервера и клиента чата.
Реализовать созданные интерфейсы простым логированием. Со стороны клиента – только SocketThreadListener,
со стороны сервера – оба интерфейса.

3.
Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы,
и фуллстэк разработчики, совмещающие в себе обе компетенции.
Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
все его методы.
 */

import org.example.lesson2.developers.*;
import org.example.lesson2.serverchat.WindowServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        new WindowServer();

        FullStack fullDev = new DeveloperFull();
        fullDev.createServer();
        fullDev.createFront();

        BackEnder backDev = new DeveloperBack();
        backDev.createServer();

        List<BackEnder> listDevs = Arrays.asList(fullDev, backDev);
        for (BackEnder listDev : listDevs) {
            listDev.createServer();
        }

        Developer developer = new DeveloperFront();
        if (developer instanceof FrontEnder) {
            ((FrontEnder) developer).createFront();
        }

    }
}
