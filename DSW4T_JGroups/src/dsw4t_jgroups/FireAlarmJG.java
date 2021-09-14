/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_jgroups;

import org.jgroups.JChannel;
import org.jgroups.Message;

/**
 *
 * @author Vinicius
 */
public class FireAlarmJG {
    
    JChannel channel;
    
    public void raise() throws Exception{
        channel = new JChannel();
        channel.connect("AlarmChannel");
        Message msg = new Message(null, null, "Fire!");
        channel.send(msg);
        channel.close();
    }
    
}
