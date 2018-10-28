package testKafka;

import java.io.IOException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;

public class producer {
	
	@Autowired
	private static Logger logger = Logger.getLogger(producer.class);
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-producer-kafka.xml");
		System.out.println(context.getApplicationName());
		KafkaTemplate kafkaTemplate = (KafkaTemplate) context.getBean("kafkaTemplate");
        for (int i = 0; i < 10; i++) {
            logger.info("======send=====" + i);
            kafkaTemplate.sendDefault("Hello, Kafka---");
//            kafkaTemplate.send("---+++---", i);
        }
	}
	
}





