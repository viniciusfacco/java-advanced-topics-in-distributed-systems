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

public class UDPClient{
    
    public void envia(String msg, String server){
        // args give message contents and server hostname!
        DatagramSocket aSocket = null;
        Output saida = new Output();
        saida.setTitle("UDP Client");
        try {
            aSocket = new DatagramSocket();
            byte [] m = msg.getBytes();
            InetAddress aHost = InetAddress.getByName(server);
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket(m, msg.length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            saida.append("Reply: " + new String(reply.getData()));
        }catch (SocketException e){saida.append("Socket: " + e.getMessage());
        }catch (IOException e){saida.append("IO: " + e.getMessage());
        }finally {if(aSocket != null) aSocket.close();}
    }
    
}