/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_jms;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class DSW4T_JMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Object[] possibleValues = { "Publish Alarm", "Consume Alarms"};
        Object selectedValue = JOptionPane.showInputDialog(null,
            "Select the operation", "Operation Mode",
            JOptionPane.QUESTION_MESSAGE, null,
            possibleValues, possibleValues[0]);  
        Output saida = new Output();
        String ip = JOptionPane.showInputDialog("Server");
        switch(selectedValue.toString()){
            case "Publish Alarm": {
                int cont = 0;
                saida.append("Starting...");
                while(true){
                    FireAlarmJMS alarm = new FireAlarmJMS();
                    alarm.raise(cont, ip);
                    saida.append("Message " + cont + " sent.");
                    System.out.println("Message " + cont + " sent.");
                    cont++;
                    Thread.sleep(2000);
                }
            }
            case "Consume Alarms": {
                saida.append("Starting...");
                while (true){
                    FireAlarmConsumerJMS consumer = new FireAlarmConsumerJMS();
                    String msg = consumer.await(ip);
                    saida.append("Message: " + msg);
                    System.out.println("Message: " + msg);
                    //Thread.sleep(5000);
		}
            }
        }
    }
    
}
