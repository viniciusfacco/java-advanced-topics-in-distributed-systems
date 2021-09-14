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
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Hello World!";
    }
    
    public float somar(int valor1, int valor2){
        return valor1 + valor2;
    }
    
    public float subtrair(int valor1, int valor2){
        return valor1 - valor2;
    }
    
    public float multiplicar(int valor1, int valor2){
        return valor1 * valor2;
    }
    
    public float dividir(int valor1, int valor2){
        return valor1 / valor2;
    }
    
    public void start() {
        // Cria e instala o gerenciador de segurança
        //if (System.getSecurityManager() == null) {
        //    System.setSecurityManager(new RMISecurityManager());
        //}        
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            HelloImpl obj = new HelloImpl();
            // Associa o objeto com o nome "HelloServer"
            Naming.rebind("//localhost:1099/HelloServer", obj);
            System.out.println("HelloServer bound in registry");
        } catch (Exception e) {
            System.out.println("HelloImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}