package be.groept.mock.service;

import be.groept.mock.dao.ReceptionNotOkException;

public interface BusinessService {

	void processSomething() throws ReceptionNotOkException;
}
