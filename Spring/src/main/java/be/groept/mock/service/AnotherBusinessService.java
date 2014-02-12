package be.groept.mock.service;

import be.groept.mock.dao.ReceptionNotOkException;

public interface AnotherBusinessService {

	// For exercise 1
	void callsDependencyExactly10Times() throws ReceptionNotOkException;

	void callsDependencyMoreThenOnce() throws ReceptionNotOkException;

	void callsDependencyMaximumThousand() throws ReceptionNotOkException;

	void callsDependencyBetweenHundredAndThousandTimes() throws ReceptionNotOkException;

	// For exercise 3

	void callsDependency20TimesCyclesParameterEach5thTime() throws ReceptionNotOkException;
}
