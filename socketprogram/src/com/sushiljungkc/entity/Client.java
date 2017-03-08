/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc.entity;

import java.net.Socket;

/**
 *
 * @author User
 */
public class Client {
    private String clientName;
    private Socket clientSocket;

    public Client() {
    }

    public Client(String clientName, Socket clientSocket) {
        this.clientName = clientName;
        this.clientSocket = clientSocket;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    
    
}
