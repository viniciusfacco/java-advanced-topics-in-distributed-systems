/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw5t_javarmi;

import java.rmi.RemoteException;

/**
 *
 * @author Vinicius
 */
public class DSW5T_JavaRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        HelloImpl server = new HelloImpl();
        server.start();
    }
    
}
