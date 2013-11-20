package be.groept.hibernate.entities.types;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Password implements Serializable {

	private String password;
	private String clearText;

	public Password(String clearText) {
		this.clearText = clearText;
	}

	Password(String clearText, String password) {
		this.password = password;
		this.clearText = clearText;
	}

	public String getPassword() {
		return password;
	}

	public String getClearText() {
		return clearText;
	}

	public void setClearText(String clearText) {
		this.clearText = clearText;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}