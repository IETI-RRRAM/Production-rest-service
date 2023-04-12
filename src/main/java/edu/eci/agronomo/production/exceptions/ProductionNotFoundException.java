package edu.eci.agronomo.production.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductionNotFoundException extends ResponseStatusException {

    public ProductionNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "Production with ID: " + id + " not found");
    }
}
