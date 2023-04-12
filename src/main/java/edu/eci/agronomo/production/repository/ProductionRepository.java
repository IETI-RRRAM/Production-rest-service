package edu.eci.agronomo.production.repository;

import edu.eci.agronomo.production.model.production.Production;
import edu.eci.agronomo.production.model.production.ProductionDto;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductionRepository {

    public ArrayList<Production> findAll();

    public Optional<Production> findById(String id);

    public Production save(ProductionDto productionDto);

    public void delete(String id);

    public Production update(String id, ProductionDto productionDto);

}
