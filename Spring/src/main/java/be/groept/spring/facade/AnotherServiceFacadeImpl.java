package be.groept.spring.facade;

import be.groept.spring.repository.ServiceRepository;

public class AnotherServiceFacadeImpl implements AnotherServiceFacade {

	private ServiceRepository serviceRepository;

	public ServiceRepository getServiceRepository() {
		return serviceRepository;
	}

	public void setServiceRepository(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}
}
