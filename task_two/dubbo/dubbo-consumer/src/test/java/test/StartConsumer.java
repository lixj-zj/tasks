package test;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dubbo.service.DemoService;

public class StartConsumer {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        System.out.println("消费已经启动。。。");
        DemoService demoService = (DemoService)context.getBean("demoService");
        System.out.println(demoService.getPermissions(111L));
        System.in.read();
	}
}

