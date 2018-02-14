package ioc.injection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		PropertyBean pb = (PropertyBean) ctx.getBean("propertyBean");
		Map<Object, Object> address = pb.getAddress();
		Iterator<Object> itor = address.keySet().iterator();
		while(itor.hasNext()) {
			String i = (String) itor.next();
			System.out.println(i+":"+address.get(i));
		}
	}
}
