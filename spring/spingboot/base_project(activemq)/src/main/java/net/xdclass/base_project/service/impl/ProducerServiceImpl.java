package net.xdclass.base_project.service.impl;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import net.xdclass.base_project.service.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 功能描述：消息生产者
 *
 * <p> 创建时间：May 2, 2018 11:29:47 PM </p> 
 *
 *@作者 小D课堂  小D
 */
@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsMessagingTemplate jmsTemplate; //用来发送消息到broker的对象
	
	//发送消息，destination是发送到的队列，message是待发送的消息
	@Override
	public void sendMessage(Destination destination, String message) {
		
		jmsTemplate.convertAndSend(destination, message);
		
	}

	
	//发送消息，destination是发送到的队列，message是待发送的消息
	@Override
	public void sendMessage(final String message) {
		jmsTemplate.convertAndSend( message);
		
	}

	//=======发布订阅相关代码=========
	
	@Autowired
	private Topic topic;
	
	
	 @Override
	public void publish(String msg) {
		this.jmsTemplate.convertAndSend(this.topic, msg);
		
	}

	 	
}
