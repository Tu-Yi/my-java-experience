package net.xdclass.base_project;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication //一个注解顶下面3个
@EnableJms
public class XdclassApplication {



	@Bean
	public Topic topic(){
		return new ActiveMQTopic("video.topic");
	}
	
	
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("common.queue");
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(XdclassApplication.class, args);
	}
	
	
	 @Bean
	    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
	        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
	        bean.setPubSubDomain(true);
	        bean.setConnectionFactory(activeMQConnectionFactory);
	        return bean;
	    }
	 
	
	
}
