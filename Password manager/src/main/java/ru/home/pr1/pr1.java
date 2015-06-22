package ru.home.pr1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFrame;

public class pr1 extends JFrame implements Runnable{
    static private Socket connection ;
    static private ObjectOutputStream output;
    static private ObjectInputStream input ;
    public static void main(String[] args) {
       new Thread(new pr1("test")).start();

    }
    public pr1(String name) {
        super(name);
        setLayout(new FlowLayout());
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        final JTextField t1 = new JTextField(10);
        final JButton b1 = new JButton("Send");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== b1){
                    sendData(t1.getText());
                }
            }
        });
        add(t1);
        add(b1);


    }
    @Override
    public void run() {

        try {
             while (true) {

                 connection = new Socket(InetAddress.getByName("127.0.0.1"), 566);
                 output = new ObjectOutputStream(connection.getOutputStream());
                 input = new ObjectInputStream(connection.getInputStream());
                 JOptionPane.showMessageDialog(null, (String) input.readObject());

             }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void sendData(Object obj) {
        try {
            output.flush();
            output.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
