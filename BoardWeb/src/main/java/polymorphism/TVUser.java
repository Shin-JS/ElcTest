package polymorphism;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TVUser와 SamsungTV/LgTV간의 관계는 결합도가 아주 높다.
public class TVUser {
	public static void main(String[] args) {
		/*SamsungTV tv = new SamsungTV();*/
		/*LgTV tv = new LgTV();*/
		/*TV tv = new SamsungTV();*/
		/*TV tv = new LgTV();*/
		/*BeanFactory factory = new BeanFactory();
		TV tv = (TV) factory.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();*/
		
		TV tv1 = new SamsungTV();
		TV tv2 = new SamsungTV();
		TV tv3 = new SamsungTV();
	}
}
