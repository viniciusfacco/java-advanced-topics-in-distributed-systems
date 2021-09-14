/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_javaspaces;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class DSW4T_JavaSpaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Object[] possibleValues = { "Write Message", "Read Message"};
        Object selectedValue = JOptionPane.showInputDialog(null,
            "Select the operation", "Operation Mode",
            JOptionPane.QUESTION_MESSAGE, null,
            possibleValues, possibleValues[0]);        
        
        switch(selectedValue.toString()){
            case "Write Message": {
                WriteMessage wmessage = new WriteMessage();
                wmessage.write();
                System.exit(0);
                break;
            }
            case "Read Message": {
                ReadMessage rmessage = new ReadMessage();
                rmessage.read();
                break;
            }
        }
    }
    
}
