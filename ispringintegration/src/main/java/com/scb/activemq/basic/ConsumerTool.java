package com.scb.activemq.basic;

import javax.jms.Connection;     
import javax.jms.Destination;     
import javax.jms.JMSException;     
import javax.jms.MessageConsumer;     
import javax.jms.Session;     
import javax.jms.MessageListener;     
import javax.jms.Message;     
import javax.jms.TextMessage;     
    
import org.apache.activemq.ActiveMQConnection;     
import org.apache.activemq.ActiveMQConnectionFactory;     
    
public class ConsumerTool implements MessageListener {     
    
    private String user = ActiveMQConnection.DEFAULT_USER;     
    
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;     
    
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;     
    
    private String subject = "TOOL.DEFAULT";     
    
    private Destination destination = null;     
    
    private Connection connection = null;     
    
    private Session session = null;     
    
    private MessageConsumer consumer = null;     
    
    // 初始化     
    private void initialize() throws JMSException, Exception {  
     //连接工厂是用户创建连接的对象，这里使用的是ActiveMQ的ActiveMQConnectionFactory根据url，username和password创建连接工厂。  
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(     
                user, password, url);   
        //连接工厂创建一个jms connection  
        connection = connectionFactory.createConnection();     
        //是生产和消费的一个单线程上下文。会话用于创建消息的生产者，消费者和消息。会话提供了一个事务性的上下文。  
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  //不支持事务   
        //目的地是客户用来指定他生产消息的目标还有他消费消息的来源的对象，两种消息传递方式：点对点和发布/订阅  
        destination = session.createQueue(subject);   
        //会话创建消息的生产者将消息发送到目的地  
        consumer = session.createConsumer(destination);     
             
    }     
    
    // 消费消息     
    public void consumeMessage() throws JMSException, Exception {     
        initialize();     
        connection.start();     
             
        System.out.println("Consumer:->Begin listening...");     
        // 开始监听     
        consumer.setMessageListener(this);     
        // Message message = consumer.receive();     
    }     
    
    // 关闭连接     
    public void close() throws JMSException {     
        System.out.println("Consumer:->Closing connection");     
        if (consumer != null)     
            consumer.close();     
        if (session != null)     
            session.close();     
        if (connection != null)     
            connection.close();     
    }     
    
    // 消息处理函数     
    public void onMessage(Message message) {     
        try {     
            if (message instanceof TextMessage) {     
                TextMessage txtMsg = (TextMessage) message;     
                String msg = txtMsg.getText();     
                System.out.println("Consumer:->Received: " + msg);     
            } else {     
                System.out.println("Consumer:->Received: " + message);     
            }     
        } catch (JMSException e) {     
            // TODO Auto-generated catch block     
            e.printStackTrace();     
        }     
    }     
}   