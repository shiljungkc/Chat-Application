/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc.listener;

import com.sushiljungkc.Handler.ClientHandler;
import com.sushiljungkc.Handler.UserHandler;
import com.sushiljungkc.chatcommand.ChatCommand;
import com.sushiljungkc.chatcommand.ListCommand;
import com.sushiljungkc.chatcommand.PublicMessage;
import com.sushiljungkc.entity.Client;
import com.sushiljungkc.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author User
 */
public class ClientListener {

    private Socket client;
    private BufferedReader reader;
    private Client c;
    private UserHandler uh;
    private PrintStream ps;
    private ClientHandler ch;

    public ClientHandler getCh() {
        return ch;
    }

    public ClientListener() {
    }
    

    public ClientListener(Socket client, ClientHandler ch) {

        this.client = client;
        this.uh = new UserHandler();
        this.ch = ch;

        new Thread() {

            public void run() {
                try {
                    login();
                    String line = "";
                    while (!(line = reader.readLine()).equals("exit")) {
                        String message = c.getClientName() + " says ::"
                                + " " + line;
                        System.out.println(message);
                        
                        String[] tokens=line.split(";");
                        ChatCommand cc;
                        if(tokens[0].equals("list"))
                        {
                          cc=new ListCommand(ch);
                          cc.execute(c, message);
                        }
                        else if(tokens[0].equals("pm"))
                        {
                            Client client=ch.getByName(tokens[1]);
                            String msg=client.getClientName()+" Says: "+tokens[2];
                            new PrintStream(client.getClientSocket().getOutputStream()).println(tokens[2]);
                                  
                        }
                        else
                        {
                        //=====broadcasting the public message==========
                         cc=new PublicMessage(ch);
                         cc.execute(c, message);
                        }
                        
                    }

                } catch (Exception e) {
                }
            }

            public void login() throws IOException {
                System.out.println("" + client.getInetAddress().getHostName());
                ps = new PrintStream(client.getOutputStream());
                ps.println("enter user Name: ");
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String userName = reader.readLine();

                //=====validating the user login============
                validation(userName);
            }

            public void validation(String userName) throws IOException {

                for (User u : uh.getAllUsers()) {
                    if (userName.equals(u.getUserName())) {
                        ps.println(userName + " sucessfully connected");
                        c = new Client(userName, client);
                        ch.insert(c);

                        return;
                    }

                }

                login();
            }

        }.start();

    }

}
