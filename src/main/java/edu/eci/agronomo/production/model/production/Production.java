package edu.eci.agronomo.production.model.production;

import edu.eci.agronomo.production.model.prod.Prod;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "production_collection")
public class Production implements Serializable {

    @Id
    private String id;
    private String idAnimal;
    private List<Prod> productions;
    private float totalProduction;

    public Production(String id, String idAnimal, List<Prod> productions) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.productions = productions;
        this.totalProduction = getTotalProduction();
    }

    public Production(String idAnimal, List<Prod> productions) {
        this.idAnimal = idAnimal;
        this.productions = productions;
        this.totalProduction = getTotalProduction();
        productions.forEach(prod -> {this.totalProduction+= prod.getQuantity();});
    }

    public Production(String id, ProductionDto productionDto) {
        this.id = id;
        this.idAnimal = productionDto.getIdAnimal();
        this.productions = productionDto.getProductions();
        this.totalProduction = getTotalProduction();
        productions.forEach(prod -> {this.totalProduction+= prod.getQuantity();});
    }

    public Production() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public List<Prod> getProductions() {
        return productions;
    }

    public void setProductions(List<Prod> productions) {
        this.productions = productions;
    }

    public float getTotalProduction() {
        totalProduction = 0;
        productions.forEach(prod -> {totalProduction+= prod.getQuantity();});
        return totalProduction;
    }

    public void setTotalProduction(float totalProduction) {
        this.totalProduction = totalProduction;
    }
}