package be.groept.equalshashcode;

public class MyKey {

	private String key;

	public MyKey(String key) {
		this.key = key;
	}

	//TODO somethings missing here (hint: use new EqualsBuilder().append(...)
	
	//TODO rewrite this using HashcodeBuilder.append(....)
	public int hashCode() {
		return key.hashCode();
	}
}
