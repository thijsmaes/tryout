package be.groept.mock.dao;

import java.util.Date;

import be.groept.mock.service.ProcessResult;

public interface WebserviceClient {

	WebserviceResult sendResult(ProcessResult processResult, Date date);
}
