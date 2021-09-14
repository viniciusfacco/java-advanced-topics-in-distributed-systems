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

public class TCPClient {

    public void envia(String msg, String server) {
        // arguments supply message and hostname of destination!
        Socket s = null;
        Output saida = new Output();
        saida.setTitle("TCP Client");
        try{
            int serverPort = 7896;
            s = new Socket(server, serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            out.writeUTF(msg);// UTF is a string encoding see Sn 4.3
            String data = in.readUTF();
            saida.append("Received: "+ data) ;
        } catch (UnknownHostException e){
            saida.append("Sock:"+e.getMessage());
        } catch (EOFException e){
            saida.append("EOF:"+e.getMessage());
        } catch (IOException e){
            saida.append("IO:"+e.getMessage());
        } finally {if(s!=null) try {s.close();}catch (IOException e){saida.append("close:"+e.getMessage());}}
    }
    
}