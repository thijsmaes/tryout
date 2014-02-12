package be.groept.mock.service;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ProcessResult {

	private String resultString;

	public ProcessResult(String resultString) {
		this.resultString = resultString;
	}

	public String getResultString() {
		return resultString;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !object.getClass().isAssignableFrom(ProcessResult.class)) {
			return false;
		}

		ProcessResult processResult = (ProcessResult) object;
		return new EqualsBuilder().append(resultString, processResult.getResultString()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(resultString).toHashCode();
	}

}