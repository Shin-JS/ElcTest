package ioc.injection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MapBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		MapBean mb = (MapBean)ctx.getBean("mapBean");
		Map<String, String> map = mb.getAddress();
		Iterator<String> itor = map.keySet().iterator();
		while(itor.hasNext()) {
			String key = itor.next();
			System.out.println(key+":" + map.get(key));
		}
	}
}
