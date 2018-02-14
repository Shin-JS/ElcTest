package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserXml {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV) factory.getBean("tv"); /*TV tv = new SamsungTV();*/
		/*tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();*/
		TV tv2 = (TV) factory.getBean("tv");
		TV tv3 = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();//자원해제
	}
}
