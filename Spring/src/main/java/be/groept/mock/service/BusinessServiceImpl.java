package be.groept.mock.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.groept.mock.dao.ReceptionNotOkException;
import be.groept.mock.dao.WebserviceClient;
import be.groept.mock.dao.WebserviceResult;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private WebserviceClient webserviceClient;

	@Override
	public void processSomething() throws ReceptionNotOkException {
		ProcessResult processResult = new ProcessResult(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
		WebserviceResult webserviceResult = webserviceClient.sendResult(processResult);
		webserviceResult.checkReceptionOk();
	}

	void setWebserviceClient(WebserviceClient webserviceClient) {
		this.webserviceClient = webserviceClient;
	}
}
