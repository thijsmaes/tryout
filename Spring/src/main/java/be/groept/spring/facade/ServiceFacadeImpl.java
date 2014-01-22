package be.groept.spring.facade;

import be.groept.spring.repository.ServiceRepository;

public class ServiceFacadeImpl implements ServiceFacade {

	private ServiceRepository serviceRepository;

	public ServiceFacadeImpl(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	public ServiceRepository getServiceRepository() {
		return serviceRepository;
	}
}
