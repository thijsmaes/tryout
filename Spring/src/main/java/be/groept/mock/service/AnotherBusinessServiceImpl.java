package be.groept.mock.service;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import be.groept.mock.dao.ReceptionNotOkException;
import be.groept.mock.dao.WebserviceClient;

@Profile("mocking")
@Service
public class AnotherBusinessServiceImpl implements AnotherBusinessService {

	@Autowired
	private WebserviceClient webserviceClient;

	@Override
	public void callsDependencyExactly10Times() throws ReceptionNotOkException {
		for (int i = 0; i < 10; i++) {
			webserviceClient.sendResult(new ProcessResult("testing"), new Date());
		}
	}

	@Override
	public void callsDependencyBetweenHundredAndThousandTimes() throws ReceptionNotOkException {
		int max = (int) ((100 + (Math.random() * (1000 - 100))));

		for (int i = 0; i <= max; i++) {
			webserviceClient.sendResult(new ProcessResult("testing"), new Date());
		}
	}

	@Override
	public void callsDependencyMoreThenOnce() throws ReceptionNotOkException {
		int max = (int) ((1 + (Math.random() * (10000 - 1))));
		for (int i = 0; i <= max; i++) {
			webserviceClient.sendResult(new ProcessResult("testing"), new Date());
		}

	}

	@Override
	public void callsDependencyMaximumThousand() throws ReceptionNotOkException {
		int max = (int) ((1 + (Math.random() * (1000 - 1))));
		for (int i = 0; i <= max; i++) {
			webserviceClient.sendResult(new ProcessResult("testing"), new Date());
		}
	}

	@Override
	public void callsDependency20TimesCyclesParameterEach5thTime() throws ReceptionNotOkException {
		int x = 0;
		for (int i = 0; i < 20; i++) {
			if (i % 5 == 0) {
				x = i;
			}
			webserviceClient.sendResult(new ProcessResult("testing " + x), new Date());
		}
	}
}
