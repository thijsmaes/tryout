package be.groept.mock.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mockito.Mockito.mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import be.groept.mock.dao.ReceptionNotOkException;
import be.groept.mock.dao.WebserviceClient;
import be.groept.mock.dao.WebserviceResult;
import be.groept.mock.dao.WebserviceResult.WebserviceResultStatus;
import be.groept.mock.service.MockTestSpringInjection.MockTestSpringInjectionConfiguration;

@Test
@ContextConfiguration(classes = { MockTestSpringInjectionConfiguration.class })
@ActiveProfiles("mocking")
public class MockTestSpringInjection extends AbstractTestNGSpringContextTests {

	@Autowired
	private WebserviceClient webserviceClient;
	@Autowired
	private BusinessService businessService;

	@BeforeMethod
	public void setup() {
		Mockito.reset(webserviceClient);
	}

	public void testHappyFlow() throws ReceptionNotOkException {
		
		WebserviceClient webserviceClient = mock(WebserviceClient.class);
		
		when(webserviceClient.sendResult(any(ProcessResult.class), any(Date.class))).thenReturn(
				new WebserviceResult(WebserviceResultStatus.OK));

		businessService.processSomething();

		verify(webserviceClient).sendResult(any(ProcessResult.class), any(Date.class));
	}

	public void testBusinessLogicOkCase() throws ReceptionNotOkException {
		when(webserviceClient.sendResult(any(ProcessResult.class), any(Date.class))).thenReturn(
				new WebserviceResult(WebserviceResultStatus.OK));

		businessService.processSomething();

		ProcessResult processResult = new ProcessResult(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
		verify(webserviceClient).sendResult(eq(processResult), any(Date.class));
	}

	@Test(expectedExceptions = ReceptionNotOkException.class)
	public void testBusinessLogicFailureCase() throws ReceptionNotOkException {
		when(webserviceClient.sendResult(any(ProcessResult.class), any(Date.class))).thenReturn(
				new WebserviceResult(WebserviceResultStatus.ERROR));

		businessService.processSomething();
	}

	static class MockTestSpringInjectionConfiguration {

		@Bean
		public WebserviceClient webserviceClient() {
			return Mockito.mock(WebserviceClient.class);
		}

		@Bean
		public BusinessService businessService() {
			return new BusinessServiceImpl();
		}
	}
}
