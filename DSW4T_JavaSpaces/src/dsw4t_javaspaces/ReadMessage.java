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
import net.jini.space.JavaSpace;
 
public class ReadMessage {
 
    public String read() {
        try {
            Output saida = new Output();
            saida.append("Procurando pelo servico JavaSpace...");
            Lookup finder = new Lookup(JavaSpace.class);
            JavaSpace space = (JavaSpace) finder.getService();
            if (space == null) {
                     saida.append("Servico JavaSpace nao encontrado. Encerrando...");
                    System.exit(-1);
            } 
            saida.append("O servico JavaSpace foi encontrado.");
 
            while (true) {
                Message template = new Message();
                Message msg = (Message) space.take(template, null, 60 * 1000);
                if (msg == null) {
                     saida.append("Tempo de espera esgotado. Encerrando...");
                    System.exit(0);
                }
                 saida.append("Mensagem recebida: "+ msg.content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
