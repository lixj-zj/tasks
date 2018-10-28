package testKafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.listener.MessageListener;

public final class consumer implements MessageListener<String,String> {

	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
		System.out.println("开始消费：：：：：：：：");
		System.out.println("消息： " + data);
	}
}