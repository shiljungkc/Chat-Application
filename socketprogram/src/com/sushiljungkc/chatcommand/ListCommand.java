/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc.chatcommand;

import com.sushiljungkc.Handler.ClientHandler;
import com.sushiljungkc.entity.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author User
 */
public class ListCommand extends ChatCommand{
   private ClientHandler ch;

    public ListCommand(ClientHandler ch) {
        this.ch = ch;
    }

    
   

    @Override
    public void execute(Client client, String message) throws IOException {

        StringBuffer avaiableClients=new StringBuffer();
        for(Client c:ch.getAllClients())
        {
            avaiableClients.append(c.getClientName()).append("\r\n");
        }
        PrintStream ps=new PrintStream(client.getClientSocket().getOutputStream());
        ps.println(" UsersList");
        ps.println("============");
        ps.println(avaiableClients);

    }
    
}
