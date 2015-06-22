package ru.home.pr1;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable   {
    static private ServerSocket server;
    static private Socket connection ;
    static private ObjectOutputStream output;
    static private ObjectInputStream input ;

    public void run() {
        try {
            server = new ServerSocket(566,10);
            while (true) {

                connection = server.accept();
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                output.writeObject("you send "+ (String)input.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
