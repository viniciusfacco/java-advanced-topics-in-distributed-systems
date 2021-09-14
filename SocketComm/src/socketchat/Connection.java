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

class Connection extends Thread {
    
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    Output saida;
    
    public Connection (Socket aClientSocket, int cont) {
        saida = new Output();
        saida.setTitle("Connection with the client " + cont + ": " + aClientSocket.getInetAddress().getHostName());
        saida.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream( clientSocket.getInputStream());
            out =new DataOutputStream( clientSocket.getOutputStream());
            this.start();
        } catch(IOException e) {saida.append("Connection:"+e.getMessage());}
    }
    
    public void run(){
        try {// an echo server!
            String data = in.readUTF();
                out.writeUTF(data);
        } catch(EOFException e) {saida.append("EOF:"+e.getMessage());
        } catch(IOException e) {saida.append("IO:"+e.getMessage());
        } finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
    }
}
