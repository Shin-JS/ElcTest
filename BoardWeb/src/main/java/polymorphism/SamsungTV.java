package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	//setter
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//기본생성자
	public SamsungTV() {
		System.out.println("===>samsungTV(1) 객체생성");
	}
	
	//매개변수 1개짜리 생성자
	public SamsungTV(Speaker speaker) {
		System.out.println("===>samsungTV(2) 객체생성");
		this.speaker = speaker;
	}
	
	//매개변수 2개짜리 생성자
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===>samsungTV(3) 객체생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() { //이름이 정해져있는건 아님
		System.out.println("객체 초기화 작업 처리");
	}
	
	public void destroyMethod() { //이름이 정해져있는건 아님
		System.out.println("객체 삭제전 처리할 로직 처리");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV--전원 켠다.(가격:"+price+"원)");
	}
	public void powerOff() {
		System.out.println("SamsungTV--전원 끈다.(가격:"+price+"원)");
	}
	public void volumeUp() {
		/*speaker = new SonySpeaker();*/
		speaker.volumeUp();
		/*System.out.println("SamsungTV--소리를키운다");*/
	}
	public void volumeDown() {
		/*speaker = new SonySpeaker();*/
		speaker.volumeDown();
		/*System.out.println("SamsungTV--소리를줄인다.");*/
	}
}
