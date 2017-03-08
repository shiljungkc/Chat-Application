/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc.Handler;

import com.sushiljungkc.entity.Client;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ClientHandler {
    
    List<Client> clientList=new ArrayList();
    
    public Boolean insert(Client c)
    {
        return clientList.add(c);
    }
    public List<Client> getAllClients()
    {
        return clientList;
    }
    public Client getByName(String name)
    {
       for(Client c:clientList)
       {
           if(c.getClientName().equals(name))
           {
               return c;
           }
       }
       return null;
       
    }
    public Client getByClientSocket(Socket clientSocket)
    {
        for(Client c:clientList)
        {
            if(c.getClientSocket().equals(clientSocket))
            {
                return c;
            }
        }
        return null;
        
    }
    
}
