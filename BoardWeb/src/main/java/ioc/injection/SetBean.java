package ioc.injection;

import java.util.Set;

public class SetBean {
	private Set<String> address;

	public void setAddress(Set<String> address) {
		this.address = address;
	}

	public Set<String> getAddress() {
		return address;
	}
	
}
