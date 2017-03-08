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
public class PublicMessage extends ChatCommand {

    public ClientHandler ch;

    public PublicMessage(ClientHandler ch) {
        this.ch = ch;
    }
    

    @Override
    public void execute(Client client, String message) throws IOException {
        for (Client cc : ch.getAllClients()) {
            PrintStream ps = new PrintStream(cc.getClientSocket().getOutputStream());
            ps.println(message);
        }

    }

}
