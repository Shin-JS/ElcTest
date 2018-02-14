package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("annotationContext.xml");
		TV tv = (TV) factory.getBean("tv"); /*TV tv = new SamsungTV();*/
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();//자원해제
	}
}
