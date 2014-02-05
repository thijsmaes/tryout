package be.groept.mock.dao;

import java.net.SocketTimeoutException;

import be.groept.mock.service.ProcessResult;

public class WebserviceClientImpl implements WebserviceClient {

	@Override
	public WebserviceResult sendResult(ProcessResult processResult) {
		// Normally the code placed here would call a real webservice. For the
		// understanding of mocking the rational is that we are not able to test
		// this class as the target webservice is not available in the scope of
		// our tests. Therefore we let it thrown an exception to simulate what
		// it would do if we would be using this class directly in our tests
		throw new RuntimeException(new SocketTimeoutException("Could not contact WebService"));
	}
}
