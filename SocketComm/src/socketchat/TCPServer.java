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

public class TCPServer {
    
    public void start() {
        Output saida = new Output();
        saida.setTitle("TCP Server");
        try{
            int serverPort = 7896;
            int cont = 0;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true) {
                cont++;
                Socket clientSocket = listenSocket.accept();
                saida.append("Connection with the client " + cont + " received. Starting communication channel.");
                Connection c = new Connection(clientSocket, cont);
            }
        } catch(IOException e) {saida.append("Listen :"+e.getMessage());}
    }
}
