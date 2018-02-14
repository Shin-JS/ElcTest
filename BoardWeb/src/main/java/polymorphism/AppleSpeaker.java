package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker---음량 높임");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker---음량 높임");
	}

}
