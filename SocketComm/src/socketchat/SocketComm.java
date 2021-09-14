/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socketchat;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class SocketComm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Object[] possibleValues = { "TCP - Server", "TCP - Client", "UDP - Server", "UDP - Client", "Multicast"};
        Object selectedValue = JOptionPane.showInputDialog(null,
            "Selecione o modo de operação", "Modo de Operação",
            JOptionPane.QUESTION_MESSAGE, null,
            possibleValues, possibleValues[0]);
        
        switch(selectedValue.toString()){
            case "TCP - Server": {
                TCPServer tcpserver = new TCPServer();
                tcpserver.start();
                break;
            }
            case "TCP - Client": {
                TCPClient tcpclient = new TCPClient();
                tcpclient.envia(JOptionPane.showInputDialog("Mensagem"), JOptionPane.showInputDialog("Servidor"));
                break;
            }
            case "UDP - Server": {
                UDPServer udpserver = new UDPServer();
                udpserver.start();
                break;
            }
            case "UDP - Client": {
                UDPClient udpclient = new UDPClient();
                udpclient.envia(JOptionPane.showInputDialog("Mensagem"), JOptionPane.showInputDialog("Servidor"));
                break;
            }
            case "Multicast":{
                MulticastPeer mcpeer = new MulticastPeer();
                mcpeer.envia(JOptionPane.showInputDialog("Mensagem"), JOptionPane.showInputDialog("Grupo"));
                break;
            }
        }
    
    }
    
}
