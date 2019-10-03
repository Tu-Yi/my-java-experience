package net.xdclass.base_project.service;

import javax.jms.Destination;



/**
 * 功能描述：消息生产
 *
 * <p> 创建时间：May 3, 2018 9:48:30 PM </p> 
 *
 *@作者 小D课堂  小D
 */
public interface ProducerService {

	/**
	 * 功能描述：指定消息队列，还有消息
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, final String message);
	
	/**
	 * 功能描述：使用默认消息队列， 发送消息
	 * @param message
	 */
	public void sendMessage( final String message);
	
	
	/**
	 * 功能描述：消息发布者
	 * @param msg
	 */
	public void publish(String msg);
}
