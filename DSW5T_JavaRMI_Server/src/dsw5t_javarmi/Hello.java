/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw5t_javarmi;

/**
 *
 * @author Vinicius
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    String sayHello() throws RemoteException;
    
    float somar(int valor1, int valor2) throws RemoteException;
    
    float subtrair(int valor1, int valor2) throws RemoteException;
    
    float multiplicar(int valor1, int valor2) throws RemoteException;
    
    float dividir(int valor1, int valor2) throws RemoteException;

}
