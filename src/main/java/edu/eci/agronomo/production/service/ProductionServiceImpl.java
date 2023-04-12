package edu.eci.agronomo.production.service;

import edu.eci.agronomo.production.model.production.Production;
import edu.eci.agronomo.production.model.production.ProductionDto;
import edu.eci.agronomo.production.repository.ProductionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductionServiceImpl implements ProductionService {


    @Override
    public ArrayList<Production> findAll() {
        return null;
    }

    @Override
    public Optional<Production> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Production save(ProductionDto productionDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Production update(String id, ProductionDto productionDto) {
        return null;
    }
}
