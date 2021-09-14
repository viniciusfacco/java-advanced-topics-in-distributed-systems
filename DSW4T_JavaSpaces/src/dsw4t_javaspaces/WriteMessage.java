/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_javaspaces;

/**
 *
 * @author Vinicius
 */
import javax.swing.JOptionPane;
import net.jini.space.JavaSpace;
 
public class WriteMessage {
 
    public void write() {
        try {
            String strmsg;
            Output saida = new Output();
            saida.append("Procurando pelo servico JavaSpace...");
            Lookup finder = new Lookup(JavaSpace.class);
            JavaSpace space = (JavaSpace) finder.getService();
            if (space == null) {
                     saida.append("Serviço JavaSpace nao encontrado. Encerrando...");
                    System.exit(-1);
            } 
            saida.append("O servico JavaSpace foi encontrado.");
            
            Message msg = new Message();
            while(JOptionPane.showConfirmDialog(null, "Would You like to write a message?","Message",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    strmsg= JOptionPane.showInputDialog("Mensagem");
                    msg.content = strmsg;
                    space.write(msg, null, 60 * 1000);
                    saida.append("Mensagem escrita: " + strmsg);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
