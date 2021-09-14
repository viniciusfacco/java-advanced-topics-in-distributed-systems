/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_jgroups;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.Receiver;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/**
 *
 * @author Vinicius
 */
public class FireAlarmConsumerJG extends ReceiverAdapter {
    
    JChannel channel;
    Output saida;
    
    public void start() throws Exception{
        saida = new Output();
        channel=new JChannel();
        channel.setReceiver(this);
        channel.connect("AlarmChannel");        
    }
    
    public void stop(){
        channel.close();
    }
    
    public void receive(Message msg) {
        //System.out.println(msg.getSrc() + ": " + msg.getObject());
        saida.append("Alerta: " + msg.getObject());
    }
}
