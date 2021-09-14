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
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloClient {
    
    Hello obj;

    public void start(String server, String porta) {
        obj = null;
        try {
            //obj = (Hello)Naming.lookup("//localhost:1099/HelloServer");
            obj = (Hello)Naming.lookup("//" + server + ":" + porta + "/HelloServer");
            //message = obj.sayHello();
        } catch (Exception e) {
            System.out.println("HelloCleint exception: " + e.getMessage());
            e.printStackTrace();
        }
        //System.out.println(message);
    }
    
    public float soma(int v1, int v2){
        float resultado = 0;
        try {
            resultado = obj.somar(v1, v2);
        } catch (RemoteException ex) {
            Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public float subtrai(int v1, int v2){
        float resultado = 0;
        try {
            resultado = obj.subtrair(v1, v2);
        } catch (RemoteException ex) {
            Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public float multiplica(int v1, int v2){
        float resultado = 0;
        try {
            resultado = obj.multiplicar(v1, v2);
        } catch (RemoteException ex) {
            Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public float divide(int v1, int v2){
        float resultado = 0;
        try {
            resultado = obj.dividir(v1, v2);
        } catch (RemoteException ex) {
            Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
