package ioc.injection;

import java.util.Iterator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SetBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		SetBean sb = (SetBean) ctx.getBean("setBean");
		System.out.println(sb);
		Iterator<String> itor = sb.getAddress().iterator();
		while(itor.hasNext()) {
			System.out.println(itor.next());
		}
	}
}
