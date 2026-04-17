package com.dralquinta.microservice.service;

import com.dralquinta.microservice.api.SomethingResponse;
import com.dralquinta.microservice.repository.SomethingRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SomethingService {

    private final SomethingRepository somethingRepository;

    public SomethingService(SomethingRepository somethingRepository) {
        this.somethingRepository = somethingRepository;
    }

    public SomethingResponse getSomething() {
        return new SomethingResponse(somethingRepository.getSomething(), "mock-postgresql");
    }
}
