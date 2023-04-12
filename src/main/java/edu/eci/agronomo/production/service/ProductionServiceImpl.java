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

    @Autowired
    ProductionRepositoryImpl productionRepository;


    @Override
    public ArrayList<Production> findAll() {
        return productionRepository.findAll();
    }

    @Override
    public Optional<Production> findById(String id) {
        return productionRepository.findById(id);
    }

    @Override
    public Production save(ProductionDto productionDto) {
        return productionRepository.save(productionDto);
    }

    @Override
    public void delete(String id) {
        productionRepository.delete(id);
    }

    @Override
    public Production update(String id, ProductionDto productionDto) {
        return productionRepository.update(id, productionDto);
    }
}
