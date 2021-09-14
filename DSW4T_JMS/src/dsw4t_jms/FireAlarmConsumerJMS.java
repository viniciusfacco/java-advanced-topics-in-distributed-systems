/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw4t_jms;

/**
 *
 * @author Vinicius
 */
import java.util.Properties;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;


public class FireAlarmConsumerJMS {
	public String await(String ip){
		try {
			Properties env = new Properties();
                        env.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory"); 
                        env.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming"); 
                        env.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl"); 
                        env.setProperty("org.omg.CORBA.ORBInitialHost", ip); 
                        env.setProperty("org.omg.CORBA.ORBInitialPort", "3700");		
			InitialContext ctx = new InitialContext(env);
                        
			TopicConnectionFactory topicFactory = (TopicConnectionFactory) ctx.lookup("jms/__defaultConnectionFactory");
			Topic topic = (Topic) ctx.lookup("Alarms");
			TopicConnection topicConn = topicFactory.createTopicConnection();
			TopicSession topicSess = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicSubscriber topicSub = topicSess.createSubscriber(topic);
			topicConn.start();
			TextMessage msg = (TextMessage)topicSub.receive();
			return msg.getText();
			
		} catch (Exception e) {
			System.out.println(e);
                        return null;
		}
	}

}
