package be.groept.mock.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import be.groept.mock.dao.ReceptionNotOkException;
import be.groept.mock.dao.WebserviceClient;
import be.groept.mock.dao.WebserviceResult;
import be.groept.mock.dao.WebserviceResult.WebserviceResultStatus;

@Test
@ActiveProfiles("mocking")
public class MockTestWithManualInjection {

	public void testHappyFlow() throws ReceptionNotOkException {

		WebserviceClient webserviceClient = mock(WebserviceClient.class);
		when(webserviceClient.sendResult(any(ProcessResult.class), any(Date.class))).thenReturn(
				new WebserviceResult(WebserviceResultStatus.OK));

		BusinessServiceImpl businessService = new BusinessServiceImpl();
		businessService.setWebserviceClient(webserviceClient);
		businessService.processSomething();

		verify(webserviceClient).sendResult(any(ProcessResult.class), any(Date.class));
	}

	public void testBusinessLogicOkCase() throws ReceptionNotOkException {
		WebserviceClient webserviceClient = Mockito.mock(WebserviceClient.class);
		when(webserviceClient.sendResult(any(ProcessResult.class), any(Date.class))).thenReturn(
				new WebserviceResult(WebserviceResultStatus.OK));

		BusinessServiceImpl businessService = new BusinessServiceImpl();
		businessService.setWebserviceClient(webserviceClient);
		businessService.processSomething();

		ProcessResult processResult = new ProcessResult(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));

		Mockito.

		verify(webserviceClient).sendResult(eq(processResult), any(Date.class));
	}

	@Test(expectedExceptions = ReceptionNotOkException.class)
	public void testBusinessLogicFailureCase() throws ReceptionNotOkException {
		WebserviceClient webserviceClient = Mockito.mock(WebserviceClient.class);
		when(webserviceClient.sendResult(any(ProcessResult.class), any(Date.class))).thenReturn(
				new WebserviceResult(WebserviceResultStatus.ERROR));

		BusinessServiceImpl businessService = new BusinessServiceImpl();
		businessService.setWebserviceClient(webserviceClient);
		businessService.processSomething();
	}
}
