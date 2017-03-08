/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc.chatcommand;

import com.sushiljungkc.entity.Client;
import java.io.IOException;

/**
 *
 * @author User
 */
public abstract class ChatCommand {
    public abstract void execute(Client client,String message) throws IOException;
    
}
