package ioc.injection;

import java.util.List;

public class CollectionBean {
	private List<String> address;
	
	//getter/setter
	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}
}
