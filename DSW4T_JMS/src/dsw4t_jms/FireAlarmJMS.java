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
import java.util.Hashtable;
import java.util.Properties;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;



public class FireAlarmJMS {
	
	public void raise(int contador, String ip){
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
			TopicPublisher topicPub = topicSess.createPublisher(topic);
			TextMessage msg = topicSess.createTextMessage();
			msg.setText("Fire! " + contador);
			topicPub.publish(msg);
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
