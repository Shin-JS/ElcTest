package polymorphism;



import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	/*@Autowired //type으로 DI해주는 annotation
	@Qualifier("apple") //동일 타입의 Component가 여러개일때 이름으로 DI해주는 annotation*/
	/*@Resource(name="sony")*/
	@Inject
	@Qualifier("sony")
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTv--전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTv--전원 끈다.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
