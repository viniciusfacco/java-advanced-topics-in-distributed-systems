/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_jgroups;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class DSW4T_JGroups {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Object[] possibleValues = { "Wait Alarms", "Send Alarm"};
        Object selectedValue = JOptionPane.showInputDialog(null,
            "Select the operation", "Operation Mode",
            JOptionPane.QUESTION_MESSAGE, null,
            possibleValues, possibleValues[0]);        
        
        switch(selectedValue.toString()){
            case "Wait Alarms": {
                FireAlarmConsumerJG alarmCall = new FireAlarmConsumerJG();
                alarmCall.start();
            }
            case "Send Alarm": {
                FireAlarmJG alarm = new FireAlarmJG();
                alarm.raise();
                break;
            }
        }
    }
    
}
