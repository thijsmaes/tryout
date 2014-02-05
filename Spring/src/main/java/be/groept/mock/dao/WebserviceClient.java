package be.groept.mock.dao;

import be.groept.mock.service.ProcessResult;

public interface WebserviceClient {

	WebserviceResult sendResult(ProcessResult processResult);
}
