/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc;

import com.sushiljungkc.Handler.ClientHandler;
import com.sushiljungkc.listener.ClientListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author User
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int port = 9000;
        ClientHandler handler=new ClientHandler();

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("server is running ");

            while (true) {

                Socket client = server.accept();
                ClientListener cl=new ClientListener(client,handler);
               

            }
        } catch (IOException e) {
            System.out.println("" + e.toString());
        }

    }

}
