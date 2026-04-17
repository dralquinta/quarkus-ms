package com.dralquinta.microservice.repository;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@DefaultBean
public class MockSomethingRepository implements SomethingRepository {

    @Override
    public String getSomething() {
        return "mock-something";
    }
}
