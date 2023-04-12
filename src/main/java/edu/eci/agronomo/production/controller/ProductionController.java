package edu.eci.agronomo.production.controller;

import edu.eci.agronomo.production.exceptions.ProductionNotFoundException;
import edu.eci.agronomo.production.model.production.Production;
import edu.eci.agronomo.production.model.production.ProductionDto;
import edu.eci.agronomo.production.service.ProductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/production")
public class ProductionController {

    @Autowired
    private ProductionServiceImpl productionService;

    // Get all productions
    @GetMapping
    public List<Production> getAllProductions() {
        return productionService.findAll();
    }

    // Get production by ID
    @GetMapping("/{id}")
    public ResponseEntity<Production> getProductionById(@PathVariable String id) {
        Optional<Production> production = productionService.findById(id);
        if (production.isPresent()) {
            return ResponseEntity.ok(production.get());
        } else {
            throw new ProductionNotFoundException(id);
        }
    }

    // Create a new production
    @PostMapping
    public ResponseEntity<Production> createProduction(@RequestBody ProductionDto productionDto) {
        Production createdProduction = productionService.save(productionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduction);
    }

    // Delete a production
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduction(@PathVariable String id) {
        Optional<Production> production = productionService.findById(id);
        if (production.isPresent()) {
            productionService.delete(production.get().getId());
            return ResponseEntity.ok().build();
        } else {
            throw new ProductionNotFoundException(id);
        }
    }

    //Update a production
    @PutMapping("/{id}")
    public ResponseEntity<Production> updateProduction(@PathVariable String id, @RequestBody ProductionDto updatedProduction) {
        Optional<Production> production = productionService.findById(id);
        if (production.isPresent()) {
            Production savedProduction = productionService.update(id, updatedProduction);
            return ResponseEntity.ok(savedProduction);
        } else {
            throw new ProductionNotFoundException(id);
        }
    }
}
