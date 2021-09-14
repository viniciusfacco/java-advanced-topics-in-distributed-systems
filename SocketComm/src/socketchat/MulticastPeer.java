/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socketchat;

/**
 *
 * @author Vinicius
 */
import java.net.*;
import java.io.*;

public class MulticastPeer{
    
    public void envia(String msg, String grupo){
        // args give message contents & destination multicast group (e.g. "228.5.6.7")!
        MulticastSocket s =null;
        Output saida = new Output();
        saida.setTitle("Multicast");
        try {
            InetAddress group = InetAddress.getByName(grupo);
            s = new MulticastSocket(6789);
            s.joinGroup(group);
            byte [] m = msg.getBytes();
            DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
            s.send(messageOut);
            // get messages from others in group
            byte[] buffer = new byte[1000];
            for(int i=0; i< 3; i++) {
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                s.receive(messageIn);
                saida.append("Received:" + new String(messageIn.getData()));
            }
            s.leaveGroup(group);
            }catch (SocketException e){saida.append("Socket: " + e.getMessage());
            }catch (IOException e){saida.append("IO: " + e.getMessage());
            }finally {if(s != null) s.close();}
    }
    
}