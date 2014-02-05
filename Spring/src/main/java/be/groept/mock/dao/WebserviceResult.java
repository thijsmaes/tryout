package be.groept.mock.dao;

public class WebserviceResult {

	private WebserviceResultStatus webserviceResultStatus;

	public WebserviceResult(WebserviceResultStatus webserviceResultStatus) {
		this.webserviceResultStatus = webserviceResultStatus;
	}

	public void checkReceptionOk() throws ReceptionNotOkException {
		if (webserviceResultStatus != WebserviceResultStatus.OK) {
			throw new ReceptionNotOkException();
		}
	}

	public enum WebserviceResultStatus {
		OK, WARNING, ERROR;
	}
}
