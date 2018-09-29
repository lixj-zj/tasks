package test;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartProvider {
	public static void main(String[] args) throws IOException {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 System.out.println(context.getDisplayName() + ": here");
		 context.start();
         System.out.println("服务已经启动...");
         System.in.read();
	}
}
